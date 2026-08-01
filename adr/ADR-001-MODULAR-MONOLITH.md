# ADR-001: Monolito modular

- **Estado:** aceptada

## Contexto

El producto comienza con una barbería y puede crecer a varias. Los microservicios aumentarían operación, coste y fallos distribuidos.

## Decisión

Backend Spring Boot único, dividido en módulos internos con dependencias controladas.

## Consecuencias

- despliegue sencillo;
- transacciones locales;
- pruebas simples;
- disciplina necesaria para evitar monolito desordenado;
- extracción futura posible si una frontera lo justifica.
