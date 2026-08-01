package com.barberiasyassin.api.appointments.domain;

import com.barberiasyassin.api.branches.domain.Branch;
import com.barberiasyassin.api.branches.infrastructure.BranchRepository;
import com.barberiasyassin.api.catalog.domain.Service;
import com.barberiasyassin.api.catalog.infrastructure.ServiceRepository;
import com.barberiasyassin.api.companies.domain.Company;
import com.barberiasyassin.api.companies.infrastructure.CompanyRepository;
import com.barberiasyassin.api.customers.domain.Customer;
import com.barberiasyassin.api.customers.infrastructure.CustomerRepository;
import com.barberiasyassin.api.employees.domain.Employee;
import com.barberiasyassin.api.employees.infrastructure.EmployeeRepository;
import com.barberiasyassin.api.appointments.infrastructure.AppointmentRepository;
import com.barberiasyassin.api.shared.tenant.TenantContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AppointmentFlowTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    private UUID tenantId;
    private Branch branch;
    private Employee employee;
    private Service service;
    private Customer customer;

    @BeforeEach
    void setUp() {
        // Create Tenant
        Company company = new Company();
        company.setName("Test Barberia");
        company.setSlug("test-barberia-" + UUID.randomUUID());
        company = companyRepository.save(company);
        tenantId = company.getId();

        // Set context
        TenantContext.setCurrentTenant(tenantId);

        // Create Branch
        branch = new Branch();
        branch.setName("Central Test");
        branch.setAddressLine1("Street 1");
        branch.setCity("Madrid");
        branch.setPostalCode("28001");
        branch.setCountry("Spain");
        branch = branchRepository.save(branch);

        // Create Employee
        employee = new Employee();
        employee.setName("Barber John");
        employee.setStatus("ACTIVE");
        employee.getBranches().add(branch);
        employee = employeeRepository.save(employee);

        // Create Service
        service = new Service();
        service.setName("Haircut");
        service.setDurationMinutes(30);
        service.setPriceMinor(1500L);
        service.setStatus("ACTIVE");
        service = serviceRepository.save(service);

        // Create Customer
        customer = new Customer();
        customer.setName("Client Doe");
        customer.setEmail("client@doe.com");
        customer = customerRepository.save(customer);
    }

    @AfterEach
    void tearDown() {
        TenantContext.clear();
    }

    @Test
    void shouldSaveAppointmentAndDetectOverlaps() {
        // 1. Create a valid appointment
        Instant start = Instant.now().plus(1, ChronoUnit.DAYS);
        Instant end = start.plus(30, ChronoUnit.MINUTES);

        Appointment app1 = new Appointment();
        app1.setBranch(branch);
        app1.setCustomer(customer);
        app1.setEmployee(employee);
        app1.setStatus("CONFIRMED");
        app1.setStartsAt(start);
        app1.setEndsAt(end);
        app1.setServiceId(service.getId());
        app1.setServiceNameSnapshot(service.getName());
        app1.setServiceDurationMinutesSnapshot(service.getDurationMinutes());
        app1.setServicePriceMinorSnapshot(service.getPriceMinor());
        app1.setEstimatedTotalMinor(service.getPriceMinor());
        app1.setSource("WEB");
        app1.setCreatedByType("CUSTOMER");
        app1 = appointmentRepository.save(app1);

        assertNotNull(app1.getId());
        assertEquals(tenantId, app1.getCompanyId());

        // 2. Check overlap
        List<Appointment> overlaps = appointmentRepository.findOverlappingAppointments(
                tenantId, employee.getId(), start.plus(10, ChronoUnit.MINUTES), end.plus(10, ChronoUnit.MINUTES)
        );
        assertFalse(overlaps.isEmpty());
        assertEquals(app1.getId(), overlaps.get(0).getId());
    }

    @Test
    void shouldEnforceTenantBoundaryOnAppointment() {
        // Create an appointment for tenant A
        Instant start = Instant.now().plus(1, ChronoUnit.DAYS);
        Instant end = start.plus(30, ChronoUnit.MINUTES);

        Appointment app = new Appointment();
        app.setBranch(branch);
        app.setCustomer(customer);
        app.setEmployee(employee);
        app.setStatus("CONFIRMED");
        app.setStartsAt(start);
        app.setEndsAt(end);
        app.setServiceNameSnapshot(service.getName());
        app.setServiceDurationMinutesSnapshot(service.getDurationMinutes());
        app.setServicePriceMinorSnapshot(service.getPriceMinor());
        app.setEstimatedTotalMinor(service.getPriceMinor());
        app.setSource("WEB");
        app.setCreatedByType("CUSTOMER");
        appointmentRepository.save(app);

        // Switch tenant context to B
        TenantContext.setCurrentTenant(UUID.randomUUID());

        // Try to update or delete, should throw SecurityException due to TenantEntityListener
        app.setStatus("COMPLETED");
        assertThrows(SecurityException.class, () -> {
            appointmentRepository.saveAndFlush(app);
        });
    }
}
