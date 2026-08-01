package com.barberiasyassin.api.shared.initialization;

import com.barberiasyassin.api.companies.domain.Company;
import com.barberiasyassin.api.companies.infrastructure.CompanyRepository;
import com.barberiasyassin.api.branches.domain.Branch;
import com.barberiasyassin.api.branches.infrastructure.BranchRepository;
import com.barberiasyassin.api.identity.domain.User;
import com.barberiasyassin.api.identity.domain.CompanyMembership;
import com.barberiasyassin.api.identity.infrastructure.UserRepository;
import com.barberiasyassin.api.identity.infrastructure.CompanyMembershipRepository;
import com.barberiasyassin.api.shared.tenant.TenantContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final CompanyRepository companyRepository;
    private final BranchRepository branchRepository;
    private final UserRepository userRepository;
    private final CompanyMembershipRepository companyMembershipRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${SEED_YASSIN_TENANT:true}")
    private boolean seedYassinTenant;

    @Value("${BOOTSTRAP_SUPERADMIN_EMAIL:}")
    private String superAdminEmail;

    @Value("${BOOTSTRAP_SUPERADMIN_PASSWORD:}")
    private String superAdminPassword;

    @Value("${BOOTSTRAP_SUPERADMIN_DISPLAY_NAME:Platform Owner}")
    private String superAdminDisplayName;

    public DataInitializer(CompanyRepository companyRepository,
                           BranchRepository branchRepository,
                           UserRepository userRepository,
                           CompanyMembershipRepository companyMembershipRepository,
                           PasswordEncoder passwordEncoder) {
        this.companyRepository = companyRepository;
        this.branchRepository = branchRepository;
        this.userRepository = userRepository;
        this.companyMembershipRepository = companyMembershipRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Company yassinCompany = null;
        
        if (seedYassinTenant) {
            yassinCompany = seedBarberiaYassin();
        }

        if (superAdminEmail != null && !superAdminEmail.trim().isEmpty()) {
            bootstrapSuperAdmin(yassinCompany);
        }
    }

    private Company seedBarberiaYassin() {
        log.info("Checking if Barbería Yassin tenant needs to be seeded...");
        String slug = "barberia-yassin";
        return companyRepository.findBySlug(slug)
                .orElseGet(() -> {
                    log.info("Seeding Barbería Yassin tenant...");
                    Company company = new Company();
                    company.setName("Barbería Yassin");
                    company.setSlug(slug);
                    company.setStatus("ACTIVE");
                    company.setDefaultLocale("es-ES");
                    company.setDefaultCurrency("EUR");
                    company.setDefaultTimezone("Europe/Madrid");
                    company.setPlanCode("BASIC");
                    Company savedCompany = companyRepository.save(company);

                    // Set tenant context for branch seeding
                    TenantContext.setCurrentTenant(savedCompany.getId());
                    try {
                        Branch branch = new Branch();
                        branch.setName("Barbería Yassin");
                        branch.setAddressLine1("Calle de Alfredo Aleix, 25, Local 9");
                        branch.setCity("Madrid");
                        branch.setPostalCode("28044");
                        branch.setCountry("España");
                        branch.setTimezone("Europe/Madrid");
                        branch.setStatus("ACTIVE");
                        branchRepository.save(branch);
                        log.info("Successfully seeded default Branch for Barbería Yassin.");
                    } finally {
                        TenantContext.clear();
                    }
                    return savedCompany;
                });
    }

    private void bootstrapSuperAdmin(Company company) {
        log.info("Checking if superadmin user needs to be bootstrapped...");
        userRepository.findByEmail(superAdminEmail)
                .ifPresentOrElse(
                        user -> log.info("Superadmin user already exists: {}", superAdminEmail),
                        () -> {
                            if (superAdminPassword == null || superAdminPassword.trim().isEmpty()) {
                                log.warn("BOOTSTRAP_SUPERADMIN_PASSWORD is empty. Skipping superadmin creation.");
                                return;
                            }
                            log.info("Bootstrapping superadmin user: {}", superAdminEmail);
                            User user = new User();
                            user.setEmail(superAdminEmail);
                            user.setPasswordHash(passwordEncoder.encode(superAdminPassword));
                            user.setDisplayName(superAdminDisplayName);
                            user.setStatus("ACTIVE");
                            User savedUser = userRepository.save(user);

                            if (company != null) {
                                log.info("Creating platform superadmin membership for company slug: {}", company.getSlug());
                                TenantContext.setCurrentTenant(company.getId());
                                try {
                                    CompanyMembership membership = new CompanyMembership();
                                    membership.setUser(savedUser);
                                    membership.setRole("PLATFORM_SUPER_ADMIN");
                                    membership.setStatus("ACTIVE");
                                    companyMembershipRepository.save(membership);
                                    log.info("Superadmin company membership successfully created.");
                                } finally {
                                    TenantContext.clear();
                                }
                            } else {
                                log.warn("No default company seeded. Superadmin created without company membership.");
                            }
                        }
                );
    }
}
