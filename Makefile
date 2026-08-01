.PHONY: help dev build test clean docker-up docker-down

help:
	@echo "Comandos disponibles:"
	@echo "  make dev          - Levanta el entorno de desarrollo local (Docker, backend y frontend)"
	@echo "  make build        - Compila tanto el backend (Maven) como el frontend (Next.js)"
	@echo "  make test         - Ejecuta todas las pruebas unitarias y de integración"
	@echo "  make clean        - Limpia los directorios compilados (target, .next, etc.)"
	@echo "  make docker-up    - Levanta los contenedores locales (Postgres, Mailpit, Nginx)"
	@echo "  make docker-down  - Apaga los contenedores locales"

dev: docker-up
	@echo "Iniciando backend..."
	cd apps/api && ./mvnw spring-boot:run &
	@echo "Iniciando frontend..."
	cd apps/web && npm run dev

build:
	@echo "Compilando backend..."
	cd apps/api && ./mvnw clean package -DskipTests
	@echo "Compilando frontend..."
	cd apps/web && npm run build

test:
	@echo "Ejecutando pruebas del backend..."
	cd apps/api && ./mvnw test
	@echo "Ejecutando pruebas del frontend..."
	cd apps/web && npm test

clean:
	@echo "Limpiando backend..."
	cd apps/api && ./mvnw clean || true
	@echo "Limpiando frontend..."
	rm -rf apps/web/.next apps/web/out apps/web/node_modules

docker-up:
	docker compose up -d

docker-down:
	docker compose down
