# Distributed E-Commerce Architecture

A scalable, cloud-native backend for e-commerce applications built with modern microservices architecture. This platform features modular services for authentication, product management, and order processing, secured with JWT authentication and designed for distributed deployments.

## 🏗️ Architecture Overview

This project implements a comprehensive microservices architecture using Spring Boot, featuring:

- **Service Discovery**: Netflix Eureka for service registration and discovery
- **API Gateway**: Centralized routing and load balancing
- **Message Streaming**: Apache Kafka for event-driven communication
- **Security**: JWT-based authentication and authorization
- **Containerization**: Docker support for easy deployment
- **Database**: MySQL with JPA/Hibernate for data persistence

## 🚀 Services

### Core Services

| Service | Port | Description |
|---------|------|-------------|
| **Discovery Service** | 8761 | Netflix Eureka server for service registration |
| **Gateway Service** | 8080 | API Gateway with routing and load balancing |
| **Config Server** | 8888 | Centralized configuration management |
| **Auth Service** | 8081 | JWT-based authentication and user management |
| **User Service** | 8082 | User profile and account management |
| **Product Service** | 8083 | Product catalog and inventory management |
| **Cart Service** | 8084 | Shopping cart functionality |
| **Order Service** | 8085 | Order processing and management |
| **Orchestration Service** | 8086 | Business logic orchestration and workflow |

## 🛠️ Technology Stack

- **Framework**: Spring Boot 2.x
- **Service Discovery**: Netflix Eureka
- **API Gateway**: Spring Cloud Gateway
- **Security**: Spring Security with JWT
- **Database**: MySQL with JPA/Hibernate
- **Message Queue**: Apache Kafka
- **Containerization**: Docker & Docker Compose
- **Build Tool**: Maven
- **CI/CD**: Jenkins
- **Cloud Storage**: AWS S3

## 📋 Prerequisites

- Java 8 or higher
- Maven 3.6+
- MySQL 8.0+
- Docker & Docker Compose
- Apache Kafka (optional, for event streaming)

## 🚀 Quick Start

### 1. Clone the Repository

```bash
git clone <repository-url>
cd distributed-e-com-architecture
```

### 2. Start Infrastructure Services

```bash
# Start MySQL database
docker-compose up -d mysql

# Start Kafka (if using event streaming)
docker-compose up -d kafka zookeeper
```

### 3. Build and Run Services

```bash
# Build all services
mvn clean install

# Start services in order
# 1. Discovery Service
cd discovery-service && mvn spring-boot:run

# 2. Config Server
cd config-server && mvn spring-boot:run

# 3. Gateway Service
cd gateway-service && mvn spring-boot:run

# 4. Other services
cd auth-ms && mvn spring-boot:run
cd user-service && mvn spring-boot:run
cd product-service && mvn spring-boot:run
cd cart-service && mvn spring-boot:run
cd order-service && mvn spring-boot:run
cd orchestration-service && mvn spring-boot:run
```

### 4. Access the Application

- **API Gateway**: http://localhost:8080
- **Eureka Dashboard**: http://localhost:8761
- **Config Server**: http://localhost:8888

## 🔐 Authentication

The platform uses JWT-based authentication:

1. **Register/Login**: POST to `/auth/register` or `/auth/login`
2. **Get Token**: Include JWT token in Authorization header
3. **Access Protected Resources**: Use `Bearer <token>` format

## 📊 API Documentation

### Authentication Endpoints
- `POST /auth/register` - User registration
- `POST /auth/login` - User login
- `POST /auth/refresh` - Refresh JWT token

### Product Management
- `GET /products` - Get all products
- `GET /products/{id}` - Get product by ID
- `POST /products` - Create new product (Admin only)
- `PUT /products/{id}` - Update product (Admin only)
- `DELETE /products/{id}` - Delete product (Admin only)

### Order Management
- `GET /orders` - Get user orders
- `POST /orders` - Create new order
- `GET /orders/{id}` - Get order details
- `PUT /orders/{id}/status` - Update order status (Admin only)

## 🐳 Docker Deployment

### Build Docker Images

```bash
# Build all services
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

### Run with Docker Compose

```bash
docker-compose up -d
```

## 🔧 Configuration

Configuration is managed through the Config Server. Key properties can be found in:

- `app-config/application.properties` - Global configuration
- Individual service `application.properties` - Service-specific settings

### Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `DB_HOST` | MySQL host | localhost |
| `DB_PORT` | MySQL port | 3306 |
| `DB_NAME` | Database name | ecommerce_db |
| `JWT_SECRET` | JWT signing secret | your-secret-key |
| `KAFKA_BOOTSTRAP_SERVERS` | Kafka servers | localhost:9092 |

## 🧪 Testing

```bash
# Run tests for all services
mvn test

# Run tests for specific service
cd <service-name> && mvn test
```

## 📈 Monitoring & Logging

- **Service Health**: Each service exposes health endpoints at `/actuator/health`
- **Metrics**: Spring Boot Actuator provides application metrics
- **Logging**: Structured logging with SLF4J and Logback

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🏆 Features

- ✅ Microservices Architecture
- ✅ Service Discovery & Load Balancing
- ✅ JWT Authentication & Authorization
- ✅ API Gateway with Routing
- ✅ Event-Driven Communication
- ✅ Docker Containerization
- ✅ Database Integration
- ✅ RESTful APIs
- ✅ Centralized Configuration
- ✅ Scalable Design

## 📞 Support

For support and questions, please open an issue in the GitHub repository.

---

**Built with ❤️ using Spring Boot and modern microservices patterns**
