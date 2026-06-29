# Distributed E-Commerce Architecture

Cloud-native e-commerce backend built with **Spring Boot microservices**, **Spring Cloud Gateway**, **Netflix Eureka**, **Kafka**, **JWT authentication**, **MySQL**, and **Docker**.

This project demonstrates a distributed backend architecture for common e-commerce workflows such as authentication, user management, product catalog management, cart handling, order processing, service discovery, and API gateway routing.

## Project Goal

The goal of this project is to show how a modular e-commerce backend can be split into independent services that communicate through API routing and event-driven workflows.

It focuses on:

* Microservice separation
* Service discovery
* API gateway routing
* JWT-based authentication
* MySQL-backed persistence
* Kafka-based async communication
* Docker-based local deployment
* Scalable backend design patterns

## Architecture Overview

The system uses a gateway-first architecture where external clients communicate through a central API Gateway. Services register with Eureka for discovery, while business services handle separate parts of the e-commerce workflow.

### Main Flow

```text
Client / API Consumer
        |
        v
Spring Cloud Gateway
        |
        v
Netflix Eureka Service Discovery
        |
        v
Microservices
        |
        v
MySQL / Kafka
```

## Services

| Service               | Port | Description                                          |
| --------------------- | ---: | ---------------------------------------------------- |
| Discovery Service     | 8761 | Eureka server for service registration and discovery |
| Config Server         | 8888 | Centralized configuration management                 |
| Gateway Service       | 8080 | API Gateway for routing external requests            |
| Auth Service          | 8081 | JWT-based authentication and authorization           |
| User Service          | 8082 | User profile and account management                  |
| Product Service       | 8083 | Product catalog and inventory management             |
| Cart Service          | 8084 | Shopping cart workflows                              |
| Order Service         | 8085 | Order processing and order status management         |
| Orchestration Service | 8086 | Coordinates business workflows across services       |

## Key Features

* **Microservice Architecture:** Separate services for auth, users, products, cart, orders, orchestration, gateway, config, and discovery
* **Service Discovery:** Netflix Eureka for service registration and lookup
* **API Gateway:** Centralized routing through Spring Cloud Gateway
* **Authentication:** JWT-based login and protected routes
* **Event-Driven Communication:** Kafka support for async workflows
* **Database Persistence:** MySQL with JPA/Hibernate
* **Containerization:** Docker and Docker Compose support
* **Centralized Configuration:** Config Server for shared service configuration
* **Health Monitoring:** Spring Boot Actuator health endpoints
* **Local Development Workflow:** Maven-based build and service startup commands

## Backend Engineering Highlights

* Designed service boundaries for common e-commerce workflows
* Used API Gateway to centralize client-facing routing
* Added service registration and discovery through Eureka
* Integrated JWT authentication for protected backend routes
* Used Kafka for asynchronous communication patterns
* Structured services for independent development and deployment
* Added Docker support for local infrastructure setup
* Used MySQL and JPA/Hibernate for persistence

## Technology Stack

| Area              | Technologies           |
| ----------------- | ---------------------- |
| Language          | Java                   |
| Framework         | Spring Boot 2.x        |
| API Gateway       | Spring Cloud Gateway   |
| Service Discovery | Netflix Eureka         |
| Security          | Spring Security, JWT   |
| Database          | MySQL, JPA/Hibernate   |
| Messaging         | Apache Kafka           |
| Configuration     | Spring Cloud Config    |
| Containerization  | Docker, Docker Compose |
| Build Tool        | Maven                  |
| Monitoring        | Spring Boot Actuator   |
| CI/CD             | Jenkins                |
| Cloud Storage     | AWS S3                 |

## Project Structure

```text
distributed-e-com-architecture/
├── discovery-service/
├── config-server/
├── gateway-service/
├── auth-ms/
├── user-service/
├── product-service/
├── cart-service/
├── order-service/
├── orchestration-service/
├── app-config/
├── docker-compose.yml
├── pom.xml
└── README.md
```

## API Documentation

### Authentication Endpoints

| Method | Endpoint         | Description                      |
| ------ | ---------------- | -------------------------------- |
| `POST` | `/auth/register` | Register a new user              |
| `POST` | `/auth/login`    | Authenticate user and return JWT |
| `POST` | `/auth/refresh`  | Refresh JWT token                |

### Product Endpoints

| Method   | Endpoint         | Description            |
| -------- | ---------------- | ---------------------- |
| `GET`    | `/products`      | Retrieve all products  |
| `GET`    | `/products/{id}` | Retrieve product by ID |
| `POST`   | `/products`      | Create a new product   |
| `PUT`    | `/products/{id}` | Update product         |
| `DELETE` | `/products/{id}` | Delete product         |

### Order Endpoints

| Method | Endpoint              | Description            |
| ------ | --------------------- | ---------------------- |
| `GET`  | `/orders`             | Retrieve user orders   |
| `POST` | `/orders`             | Create a new order     |
| `GET`  | `/orders/{id}`        | Retrieve order details |
| `PUT`  | `/orders/{id}/status` | Update order status    |

## Authentication Flow

The platform uses JWT-based authentication.

1. User registers or logs in through the Auth Service.
2. Auth Service validates credentials and returns a JWT.
3. Client sends the JWT in the `Authorization` header.
4. API Gateway and protected services validate the token before allowing access.

```text
Authorization: Bearer <token>
```

## Quick Start

### Prerequisites

* Java 8 or higher
* Maven 3.6+
* MySQL 8.0+
* Docker and Docker Compose
* Apache Kafka, if running event-streaming workflows locally

### Clone the Repository

```bash
git clone https://github.com/arpitJ-dev/distributed-e-com-architecture.git
cd distributed-e-com-architecture
```

### Start Infrastructure Services

```bash
docker-compose up -d mysql
docker-compose up -d zookeeper kafka
```

### Build All Services

```bash
mvn clean install
```

### Start Services Locally

Start services in this order:

```bash
cd discovery-service
mvn spring-boot:run
```

```bash
cd config-server
mvn spring-boot:run
```

```bash
cd gateway-service
mvn spring-boot:run
```

Then start the business services:

```bash
cd auth-ms
mvn spring-boot:run
```

```bash
cd user-service
mvn spring-boot:run
```

```bash
cd product-service
mvn spring-boot:run
```

```bash
cd cart-service
mvn spring-boot:run
```

```bash
cd order-service
mvn spring-boot:run
```

```bash
cd orchestration-service
mvn spring-boot:run
```

## Access Points

| Service          | URL                     |
| ---------------- | ----------------------- |
| API Gateway      | `http://localhost:8080` |
| Eureka Dashboard | `http://localhost:8761` |
| Config Server    | `http://localhost:8888` |

## Docker Deployment

Build Docker images for individual services:

```bash
docker build -t auth-service ./auth-ms
docker build -t user-service ./user-service
docker build -t product-service ./product-service
docker build -t cart-service ./cart-service
docker build -t order-service ./order-service
docker build -t orchestration-service ./orchestration-service
docker build -t gateway-service ./gateway-service
docker build -t discovery-service ./discovery-service
docker build -t config-server ./config-server
```

Run the system with Docker Compose:

```bash
docker-compose up -d
```

## Configuration

Configuration is managed through the Config Server.

Common configuration locations:

* `app-config/application.properties`
* Service-specific `application.properties` files

### Environment Variables

| Variable                  | Description        | Default           |
| ------------------------- | ------------------ | ----------------- |
| `DB_HOST`                 | MySQL host         | `localhost`       |
| `DB_PORT`                 | MySQL port         | `3306`            |
| `DB_NAME`                 | Database name      | `ecommerce_db`    |
| `JWT_SECRET`              | JWT signing secret | `your-secret-key` |
| `KAFKA_BOOTSTRAP_SERVERS` | Kafka broker URL   | `localhost:9092`  |

## Testing

Run tests for all services:

```bash
mvn test
```

Run tests for a specific service:

```bash
cd <service-folder>
mvn test
```

## Monitoring and Logging

The services use Spring Boot Actuator and standard Spring logging.

Useful monitoring points:

* Service health: `/actuator/health`
* Eureka service registration dashboard
* Gateway routing behavior
* Kafka broker activity
* MySQL service connectivity
* Service logs through console or container logs

## Use Cases

This project can be used as a reference for:

* Microservice-based backend design
* E-commerce service decomposition
* API gateway routing
* Service discovery using Eureka
* JWT-secured backend APIs
* Kafka-based async communication
* Docker-based local distributed systems setup

## Future Work

Planned improvements may include:

* Add OpenAPI/Swagger documentation
* Add automated integration tests across services
* Add GitHub Actions pipeline for build and test
* Add centralized logging with ELK or OpenSearch
* Add distributed tracing with Zipkin or Jaeger
* Add Kubernetes manifests
* Add load testing results for gateway and service latency
* Add clearer database schema documentation

## Troubleshooting

### Build Issues

```bash
mvn clean install
```

If build fails:

* Check Java version.
* Check Maven version.
* Confirm dependencies are available.
* Build individual services to isolate the issue.

### Service Discovery Issues

If services do not appear in Eureka:

* Confirm `discovery-service` is running on port `8761`.
* Confirm service configuration points to the correct Eureka URL.
* Restart the affected service after Eureka is available.

### Database Issues

If a service cannot connect to MySQL:

* Confirm MySQL container is running.
* Check `DB_HOST`, `DB_PORT`, and `DB_NAME`.
* Verify credentials in service configuration.

### Kafka Issues

If event workflows fail:

* Confirm Zookeeper and Kafka are running.
* Check `KAFKA_BOOTSTRAP_SERVERS`.
* Review service logs for producer or consumer errors.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Built with Spring Boot, Spring Cloud, Kafka, MySQL, Docker, and microservice architecture patterns.
