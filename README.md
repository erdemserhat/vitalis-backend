<div align="center">
  <img src="https://img.shields.io/badge/Vitalis-Healthcare%20Management-blue?style=for-the-badge&logo=health" alt="Vitalis Healthcare Management" />
  <br/>
  <h1>🏥 Vitalis - Enterprise Healthcare Management System</h1>
  <p><em>Built with Clean Architecture & Modular Monolith Design</em></p>
</div>

<div align="center">

[![Java](https://img.shields.io/badge/Java-17+-orange.svg?style=flat-square)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.2-brightgreen.svg?style=flat-square)](https://spring.io/projects/spring-boot)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.10-purple.svg?style=flat-square)](https://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/Gradle-8.0+-blue.svg?style=flat-square)](https://gradle.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg?style=flat-square)](https://www.mysql.com/)
[![Architecture](https://img.shields.io/badge/Architecture-Clean%20Architecture%20%7C%20Modular%20Monolith-lightgrey.svg?style=flat-square)](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

</div>

## 🏗️ Architecture Overview

<div align="center">
  <img src="https://img.shields.io/badge/Architecture-Clean%20Architecture-blue?style=for-the-badge" alt="Clean Architecture" />
  <img src="https://img.shields.io/badge/Pattern-Modular%20Monolith-green?style=for-the-badge" alt="Modular Monolith" />
  <img src="https://img.shields.io/badge/Design-DDD%20Approach-purple?style=for-the-badge" alt="Domain-Driven Design" />
</div>

Vitalis is built using **Clean Architecture principles** combined with a **Modular Monolith** design pattern, ensuring maintainability, scalability, and enterprise-grade code quality. The system follows the **Domain-Driven Design (DDD)** approach with clear separation of concerns across multiple modules.

### 🎯 Architecture Principles

<table>
  <tr>
    <td align="center" width="200">
      <b>🏛️ Clean Architecture</b><br/>
      <small>Strict dependency inversion with clear layer boundaries</small>
    </td>
    <td align="center" width="200">
      <b>🧩 Modular Monolith</b><br/>
      <small>Independent modules with well-defined interfaces</small>
    </td>
    <td align="center" width="200">
      <b>⚡ SOLID Principles</b><br/>
      <small>Single responsibility, open/closed, Liskov substitution, interface segregation, dependency inversion</small>
    </td>
  </tr>
  <tr>
    <td align="center" width="200">
      <b>🎯 Domain-Driven Design</b><br/>
      <small>Business logic centered around domain entities</small>
    </td>
    <td align="center" width="200">
      <b>🔐 Security-First</b><br/>
      <small>JWT-based authentication with role-based authorization</small>
    </td>
    <td align="center" width="200">
      <b>📈 Scalable Design</b><br/>
      <small>Horizontal scaling capability with stateless architecture</small>
    </td>
  </tr>
</table>

## 📁 Project Structure

<div align="center">
  <img src="https://img.shields.io/badge/Structure-Modular%20Design-orange?style=for-the-badge" alt="Modular Structure" />
</div>

<details>
<summary><b>📂 Click to expand project structure</b></summary>

```
🏗️ VITALIS PROJECT STRUCTURE TREE
vitalis-backend/
├── 📦 api/                           # Presentation Layer
│   ├── auth/
│   │   ├── permanent/
│   │   │   ├── AuthenticationController.java
│   │   │   ├── AdminController.java
│   │   │   └── AuthenticationCheckerController.java
│   │   └── test/
│   │       └── UserController.java
│   ├── admin/
│   │   └── UserRegistrationController.java
│   └── configuration/
│       ├── GlobalExceptionHandler.java
│       ├── ThymeleafConfig.kt
│       └── WebConfig.kt
│
├── 🏢 service/                       # Business Logic Layer
│   ├── security/
│   │   ├── authentication/
│   │   │   └── AuthenticationConfiguration.kt
│   │   ├── authorization/
│   │   │   └── RoleConfiguration.kt
│   │   ├── jwt/
│   │   │   ├── JwtAuthenticationFilter.kt
│   │   │   └── JwtService.kt
│   │   └── SecurityConfiguration.kt
│   ├── AccountService.java
│   ├── AuthenticationService.kt
│   └── DoctorService.kt
│
├── 💾 data/                          # Data Access Layer
│   ├── entity/
│   │   ├── Account.kt
│   │   ├── Doctor.kt
│   │   ├── Patient.kt
│   │   ├── Role.kt
│   │   ├── Dietician.kt
│   │   └── Organizer.kt
│   └── repository/
│       ├── AccountRepository.kt
│       ├── DoctorRepository.kt
│       ├── PatientRepository.kt
│       ├── RoleRepository.kt
│       ├── DieticianRepository.kt
│       └── OrganizerRepository.kt
│
├── 🔧 common/                        # Shared Components
│   ├── dto/
│   │   ├── AccountRegistrationDto.kt
│   │   ├── DoctorRegistrationDto.kt
│   │   ├── LoginResponse.kt
│   │   ├── LoginUserDto.kt
│   │   └── UserRegistrationDto.kt
│   ├── enums/
│   │   ├── Permission.kt
│   │   └── Role.kt
│   ├── exceptions/
│   │   ├── InvalidCredentialsException.java
│   │   └── UserNotFoundException.java
│   └── annotations/
│       ├── PermanentIntention.kt
│       ├── ShouldOptimized.kt
│       ├── TestIntention.kt
│       └── WorkInProgress.kt
│
└── 🚀 root/                          # Application Entry Point
    ├── VitalisApplication.java
    ├── build.gradle.kts
    ├── settings.gradle.kts
    └── gradle/
        └── wrapper/
            ├── gradle-wrapper.jar
            └── gradle-wrapper.properties

📁 RESOURCES STRUCTURE:
src/main/resources/
├── application.properties
├── static/
│   ├── add-doctor.html
│   ├── admin.html
│   ├── login.html
│   ├── register.html
│   └── vitalis.html
└── templates/
    └── (Thymeleaf templates)
```

</details>

## 🏛️ Clean Architecture Implementation

### Layer Separation

<div align="center">
  <h3>🏗️ Clean Architecture Layer Diagram</h3>
</div>

```
🏗️ VITALIS ARCHITECTURE TREE
├── 🎯 PRESENTATION LAYER (API Module)
│   ├── 📡 Controllers
│   │   ├── AuthenticationController
│   │   ├── AdminController
│   │   ├── UserController
│   │   └── DoctorController
│   ├── 📦 DTOs
│   │   ├── LoginUserDto
│   │   ├── AccountRegistrationDto
│   │   ├── DoctorRegistrationDto
│   │   └── LoginResponse
│   └── ⚙️ Web Configuration
│       ├── SecurityConfig
│       ├── WebConfig
│       └── CORS Configuration
│
├── 🏢 BUSINESS LOGIC LAYER (Service Module)
│   ├── 💼 Business Services
│   │   ├── AuthenticationService
│   │   ├── AccountService
│   │   ├── DoctorService
│   │   └── PatientService
│   ├── 🔐 Security Services
│   │   ├── JwtService
│   │   ├── SecurityConfiguration
│   │   ├── RoleConfiguration
│   │   └── JwtAuthenticationFilter
│   └── 🔑 Authentication
│       ├── AuthService
│       ├── PasswordEncoder
│       └── TokenValidation
│
├── 💾 DATA ACCESS LAYER (Data Module)
│   ├── 🏛️ Entities
│   │   ├── Account
│   │   ├── Doctor
│   │   ├── Patient
│   │   └── Role
│   ├── 🗄️ Repositories
│   │   ├── AccountRepository
│   │   ├── DoctorRepository
│   │   ├── PatientRepository
│   │   └── RoleRepository
│   └── 🗃️ Database
│       ├── MySQL Database
│       ├── JPA/Hibernate
│       └── Connection Pooling
│
└── 🔧 SHARED COMPONENTS (Common Module)
    ├── 📋 Shared DTOs
    │   ├── LoginUserDto
    │   ├── AccountDto
    │   └── ResponseDto
    ├── 📊 Enums
    │   ├── Role
    │   ├── Permission
    │   └── Status
    ├── ⚠️ Exceptions
    │   ├── UserNotFoundException
    │   ├── InvalidCredentialsException
    │   └── ValidationException
    └── 🏷️ Annotations
        ├── @PermanentIntention
        ├── @TestIntention
        └── @WorkInProgress

🔗 DEPENDENCY FLOW:
Presentation Layer → Business Logic Layer → Data Access Layer
     ↓                    ↓                    ↓
Shared Components ←─── Shared Components ←─── Shared Components
```

### Dependency Flow

<div align="center">
  <h3>📊 Dependency Inversion Principle</h3>
</div>

```
┌─────────────────────────────────────────────────────────┐
│  🎯 API Layer (Presentation)                          │
│  📡 Controllers • 📦 DTOs • ⚙️ Web Configuration     │
├─────────────────────────────────────────────────────────┤
│  🏢 Service Layer (Business Logic)                    │
│  💼 Business Services • 🔐 Security • 🔑 Auth        │
├─────────────────────────────────────────────────────────┤
│  💾 Data Layer (Data Access)                          │
│  🏛️ Entities • 🗄️ Repositories • 🗃️ Database       │
├─────────────────────────────────────────────────────────┤
│  🔧 Shared Layer (Common)                             │
│  📋 DTOs • 📊 Enums • ⚠️ Exceptions                  │
└─────────────────────────────────────────────────────────┘
```

## 🔐 Security Architecture

### JWT-Based Authentication Flow

<div align="center">
  <h3>🔐 JWT Authentication Sequence</h3>
</div>

```
🔐 JWT AUTHENTICATION FLOW TREE
├── 👤 Client
│   └── POST /auth/login (credentials)
│
├── 🎯 AuthController
│   ├── Receive login request
│   ├── Validate input data
│   ├── Call AuthService.authenticate()
│   └── Return JWT Token (HTTP-Only Cookie)
│
├── 🏢 AuthService
│   ├── authenticate(credentials)
│   │   ├── Validate credentials
│   │   ├── Call Database.validateUser()
│   │   ├── Call JwtService.generateToken()
│   │   └── Return authentication result
│   └── Password encoding/validation
│
├── 🔑 JwtService
│   ├── generateToken(user, roles)
│   │   ├── Create JWT claims
│   │   ├── Sign with secret key
│   │   ├── Set expiration time
│   │   └── Return signed token
│   └── Token validation & parsing
│
└── 💾 Database
    ├── validateUser(credentials)
    │   ├── Check user exists
    │   ├── Verify password hash
    │   ├── Load user roles
    │   └── Return user details
    └── User & role management

🔄 FLOW SEQUENCE:
Client → AuthController → AuthService → Database
  ↓         ↓              ↓           ↓
Response ← JWT Token ← Token ← User Details
```

### Role-Based Authorization

```kotlin
enum class Role(val value: String): GrantedAuthority {
    ROLE_DOCTOR("DOCTOR"),
    ROLE_ORGANIZER("ORGANIZER"),
    ROLE_DIETICIAN("DIETICIAN"),
    ROLE_PATIENT("PATIENT"),
    ROLE_ADMIN("ADMIN")
}
```

## 🧩 Modular Monolith Design

### Module Independence

Each module is designed to be **loosely coupled** and **highly cohesive**:

- **API Module**: Handles HTTP requests, validation, and response formatting
- **Service Module**: Contains core business logic and security services
- **Data Module**: Manages data persistence and domain entities
- **Common Module**: Provides shared components across all modules

### Module Communication

<div align="center">
  <h3>🧩 Modular Monolith Architecture</h3>
</div>

```
🔗 MODULE COMMUNICATION FLOW:
API Module → Service Module → Data Module
     ↓            ↓            ↓
Common Module ← Common Module ← Common Module

📋 COMMUNICATION PATTERNS:
• HTTP Requests (API → Service)
• Business Logic (Service → Data)
• Shared Objects (All → Common)
• Data Access (Service → Data)
• Security (Service → Common)

🎯 MODULE RESPONSIBILITIES:
📦 API Module: HTTP handling, validation, response formatting
🏢 Service Module: Business logic, security, authentication
💾 Data Module: Data persistence, entities, repositories
🔧 Common Module: Shared DTOs, enums, exceptions, annotations
```

## 🛠️ Technology Stack

<div align="center">
  <img src="https://img.shields.io/badge/Stack-Modern%20Java%20Ecosystem-blue?style=for-the-badge" alt="Modern Java Stack" />
</div>

### 🚀 Core Technologies

<table>
  <tr>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java" alt="Java 17+" />
      <br/><small>Modern Java features and performance</small>
    </td>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/Spring%20Boot-3.3.2-brightgreen?style=for-the-badge&logo=spring" alt="Spring Boot" />
      <br/><small>Rapid application development</small>
    </td>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/Kotlin-2.0.10-purple?style=for-the-badge&logo=kotlin" alt="Kotlin" />
      <br/><small>Enhanced developer experience</small>
    </td>
  </tr>
  <tr>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/Gradle-8.0+-blue?style=for-the-badge&logo=gradle" alt="Gradle" />
      <br/><small>Modern build system</small>
    </td>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/MySQL-8.0+-blue?style=for-the-badge&logo=mysql" alt="MySQL" />
      <br/><small>Reliable relational database</small>
    </td>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/JWT-Stateless-orange?style=for-the-badge" alt="JWT" />
      <br/><small>Secure authentication</small>
    </td>
  </tr>
</table>

### 🔧 Key Dependencies

| Category | Technology | Purpose |
|----------|------------|---------|
| 🔐 **Security** | Spring Security | Authentication and authorization |
| 💾 **Data Access** | Spring Data JPA | Data access layer |
| 🗄️ **ORM** | Hibernate | Object-relational mapping |
| 📚 **Documentation** | Springdoc OpenAPI | API documentation |
| 🧪 **Testing** | JUnit 5 | Unit and integration testing |

### 🛠️ Development Tools

<table>
  <tr>
    <td align="center" width="150">
      <img src="https://img.shields.io/badge/IDE-IntelliJ%20IDEA-black?style=for-the-badge&logo=intellij-idea" alt="IntelliJ IDEA" />
    </td>
    <td align="center" width="150">
      <img src="https://img.shields.io/badge/Server-XAMPP-orange?style=for-the-badge" alt="XAMPP" />
    </td>
    <td align="center" width="150">
      <img src="https://img.shields.io/badge/Build-Gradle-blue?style=for-the-badge&logo=gradle" alt="Gradle" />
    </td>
  </tr>
</table>

## 🚀 Getting Started

### Prerequisites

- JDK 17 or higher
- Gradle 8.0 or higher
- MySQL 8.0 or higher
- IntelliJ IDEA (recommended)

### Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/vitalis.git
   cd vitalis
  ```

2. **Set up the database**
   ```sql
   CREATE DATABASE vitalis_database;
   CREATE USER 'vitalis_user'@'localhost' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON vitalis_database.* TO 'vitalis_user'@'localhost';
   ```

3. **Configure application properties**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/vitalis_database
   spring.datasource.username=vitalis_user
   spring.datasource.password=your_password
   ```

4. **Run the application**
   ```bash
   ./gradlew bootRun
   ```

5. **Access the application**
   - Application: http://localhost:8080
   - API Documentation: http://localhost:8080/swagger-ui.html

## 📊 Key Features

<div align="center">
  <img src="https://img.shields.io/badge/Features-Enterprise%20Grade-green?style=for-the-badge" alt="Enterprise Features" />
</div>

### 🔐 Authentication & Authorization

<table>
  <tr>
    <td align="center" width="250">
      <b>🔑 JWT Authentication</b><br/>
      <small>Stateless token-based authentication</small>
    </td>
    <td align="center" width="250">
      <b>👥 Role-Based Access</b><br/>
      <small>Granular permission control (RBAC)</small>
    </td>
    <td align="center" width="250">
      <b>🔒 Secure Encoding</b><br/>
      <small>BCrypt password hashing</small>
    </td>
  </tr>
  <tr>
    <td align="center" width="250">
      <b>🍪 HTTP-Only Cookies</b><br/>
      <small>XSS protection for tokens</small>
    </td>
    <td align="center" width="250">
      <b>🛡️ CSRF Protection</b><br/>
      <small>Configurable cross-site request forgery protection</small>
    </td>
    <td align="center" width="250">
      <b>🌐 CORS Configuration</b><br/>
      <small>Cross-origin resource sharing setup</small>
    </td>
  </tr>
</table>

### 👥 Multi-Role User Management

<table>
  <tr>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/Role-Admin-red?style=for-the-badge" alt="Admin" />
      <br/><small>System administration</small>
    </td>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/Role-Doctor-blue?style=for-the-badge" alt="Doctor" />
      <br/><small>Medical professional access</small>
    </td>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/Role-Dietician-green?style=for-the-badge" alt="Dietician" />
      <br/><small>Nutrition specialist access</small>
    </td>
  </tr>
  <tr>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/Role-Organizer-purple?style=for-the-badge" alt="Organizer" />
      <br/><small>Event management access</small>
    </td>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/Role-Patient-orange?style=for-the-badge" alt="Patient" />
      <br/><small>Patient data access</small>
    </td>
    <td align="center" width="200">
      <img src="https://img.shields.io/badge/Security-Audit%20Trail-yellow?style=for-the-badge" alt="Audit Trail" />
      <br/><small>Comprehensive logging</small>
    </td>
  </tr>
</table>

### 🏥 Healthcare Domain Features

<details>
<summary><b>🏥 Click to see healthcare features</b></summary>

- **Patient Record Management**: Secure storage and retrieval of patient data
- **Medical Information Security**: HIPAA-compliant data protection
- **Role-Specific Data Access**: Granular permissions based on user roles
- **Audit Trail Capabilities**: Complete activity logging and monitoring
- **Input Validation**: Comprehensive data validation and sanitization
- **Exception Handling**: Robust error handling and user feedback

</details>

## 🧪 Development Guidelines

<div align="center">
  <img src="https://img.shields.io/badge/Quality-Clean%20Code-blue?style=for-the-badge" alt="Clean Code" />
  <img src="https://img.shields.io/badge/Patterns-SOLID%20Principles-green?style=for-the-badge" alt="SOLID Principles" />
  <img src="https://img.shields.io/badge/Testing-Comprehensive-purple?style=for-the-badge" alt="Testing" />
</div>

### 📋 Code Quality Standards

<table>
  <tr>
    <td align="center" width="250">
      <b>🧹 Clean Code</b><br/>
      <small>Readable, maintainable, and self-documenting</small>
    </td>
    <td align="center" width="250">
      <b>⚡ SOLID Principles</b><br/>
      <small>Well-structured, extensible code architecture</small>
    </td>
    <td align="center" width="250">
      <b>🧪 Test Coverage</b><br/>
      <small>Comprehensive unit and integration tests</small>
    </td>
  </tr>
  <tr>
    <td align="center" width="250">
      <b>📚 Documentation</b><br/>
      <small>Clear API documentation with OpenAPI</small>
    </td>
    <td align="center" width="250">
      <b>🔍 Code Review</b><br/>
      <small>Peer review and quality assurance</small>
    </td>
    <td align="center" width="250">
      <b>📊 Metrics</b><br/>
      <small>Code quality and performance metrics</small>
    </td>
  </tr>
</table>

### 🏗️ Architecture Patterns

| Pattern | Implementation | Purpose |
|---------|----------------|---------|
| 🗄️ **Repository Pattern** | `AccountRepository`, `DoctorRepository` | Data access abstraction |
| 🏢 **Service Layer Pattern** | `AuthenticationService`, `DoctorService` | Business logic encapsulation |
| 📦 **DTO Pattern** | `LoginUserDto`, `AccountRegistrationDto` | Data transfer object separation |
| 🏭 **Factory Pattern** | Entity creation utilities | Object creation abstraction |
| 🔧 **Builder Pattern** | Entity builders | Complex object construction |

### ✅ Best Practices

<details>
<summary><b>🔧 Click to see best practices</b></summary>

- **💉 Dependency Injection**: Spring's IoC container for loose coupling
- **⚠️ Exception Handling**: Global exception handler with proper error responses
- **📝 Logging**: Structured logging with SLF4J and proper log levels
- **⚙️ Configuration**: Externalized configuration with profiles
- **🔒 Security**: Input validation, sanitization, and secure defaults
- **📈 Performance**: Connection pooling, caching, and optimization
- **🧪 Testing**: Unit, integration, and security testing strategies

</details>

## 🔧 Configuration

### Application Properties
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/vitalis_database
spring.datasource.username=vitalis_user
spring.datasource.password=your_password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Security Configuration
jwt.secret=your_jwt_secret_key
jwt.expiration=3600000

# Server Configuration
server.port=8080
```

## 📈 Performance & Scalability

<div align="center">
  <img src="https://img.shields.io/badge/Performance-Optimized-green?style=for-the-badge" alt="Performance Optimized" />
  <img src="https://img.shields.io/badge/Scalability-Horizontal-blue?style=for-the-badge" alt="Horizontal Scaling" />
  <img src="https://img.shields.io/badge/Architecture-Stateless-orange?style=for-the-badge" alt="Stateless Architecture" />
</div>

### ⚡ Performance Optimizations

<table>
  <tr>
    <td align="center" width="250">
      <b>🔗 Connection Pooling</b><br/>
      <small>HikariCP for efficient database connections</small>
    </td>
    <td align="center" width="250">
      <b>💾 Caching Strategy</b><br/>
      <small>Spring Cache for frequently accessed data</small>
    </td>
    <td align="center" width="250">
      <b>🔄 Lazy Loading</b><br/>
      <small>JPA lazy loading for associations</small>
    </td>
  </tr>
  <tr>
    <td align="center" width="250">
      <b>📄 Pagination</b><br/>
      <small>Efficient data retrieval with pagination</small>
    </td>
    <td align="center" width="250">
      <b>🔍 Query Optimization</b><br/>
      <small>Indexed queries and efficient schemas</small>
    </td>
    <td align="center" width="250">
      <b>⚡ Response Caching</b><br/>
      <small>HTTP response caching for static content</small>
    </td>
  </tr>
</table>

### 📊 Scalability Features

<details>
<summary><b>🚀 Click to see scalability features</b></summary>

- **🧩 Modular Design**: Easy to scale individual modules independently
- **🔄 Stateless Architecture**: Horizontal scaling capability across multiple instances
- **🗄️ Database Optimization**: Indexed queries and efficient database schemas
- **⚖️ Load Balancing**: Ready for load balancer integration and distribution
- **🌐 Microservices Ready**: Architecture supports future microservices migration
- **📈 Auto-scaling**: Cloud-native design for automatic scaling

</details>

## 🧪 Testing Strategy

<div align="center">
  <img src="https://img.shields.io/badge/Testing-Unit%20Tests-blue?style=for-the-badge" alt="Unit Tests" />
  <img src="https://img.shields.io/badge/Testing-Integration%20Tests-green?style=for-the-badge" alt="Integration Tests" />
  <img src="https://img.shields.io/badge/Testing-Security%20Tests-red?style=for-the-badge" alt="Security Tests" />
</div>

### 🧪 Test Types

<table>
  <tr>
    <td align="center" width="250">
      <b>🧩 Unit Tests</b><br/>
      <small>Individual component testing with JUnit 5</small>
    </td>
    <td align="center" width="250">
      <b>🔗 Integration Tests</b><br/>
      <small>Module interaction testing</small>
    </td>
    <td align="center" width="250">
      <b>🔐 Security Tests</b><br/>
      <small>Authentication and authorization testing</small>
    </td>
  </tr>
  <tr>
    <td align="center" width="250">
      <b>🌐 API Tests</b><br/>
      <small>End-to-end API testing with TestRestTemplate</small>
    </td>
    <td align="center" width="250">
      <b>📊 Coverage Reports</b><br/>
      <small>JaCoCo code coverage analysis</small>
    </td>
    <td align="center" width="250">
      <b>🚀 Performance Tests</b><br/>
      <small>Load and stress testing capabilities</small>
    </td>
  </tr>
</table>

### 📊 Test Coverage

<details>
<summary><b>📈 Click to see test commands</b></summary>

```bash
# Run all tests
./gradlew test

# Generate coverage report
./gradlew jacocoTestReport

# Run specific test category
./gradlew test --tests "*ControllerTest"
./gradlew test --tests "*ServiceTest"
./gradlew test --tests "*RepositoryTest"

# Run with coverage
./gradlew test jacocoTestReport
```

</details>

## 📚 API Documentation

<div align="center">
  <img src="https://img.shields.io/badge/Documentation-OpenAPI%203.0-blue?style=for-the-badge" alt="OpenAPI 3.0" />
  <img src="https://img.shields.io/badge/Swagger-Interactive-green?style=for-the-badge" alt="Interactive Swagger" />
</div>

### 🌐 Available Endpoints

<table>
  <tr>
    <th>Method</th>
    <th>Endpoint</th>
    <th>Description</th>
    <th>Access</th>
  </tr>
  <tr>
    <td><code>POST</code></td>
    <td><code>/auth/login</code></td>
    <td>User authentication</td>
    <td>Public</td>
  </tr>
  <tr>
    <td><code>POST</code></td>
    <td><code>/auth/signup</code></td>
    <td>User registration</td>
    <td>Public</td>
  </tr>
  <tr>
    <td><code>GET</code></td>
    <td><code>/auth/logout</code></td>
    <td>User logout</td>
    <td>Authenticated</td>
  </tr>
  <tr>
    <td><code>GET</code></td>
    <td><code>/admin/**</code></td>
    <td>Admin-specific endpoints</td>
    <td>Admin Role</td>
  </tr>
  <tr>
    <td><code>GET</code></td>
    <td><code>/doctor/**</code></td>
    <td>Doctor-specific endpoints</td>
    <td>Doctor Role</td>
  </tr>
  <tr>
    <td><code>GET</code></td>
    <td><code>/dietitian/**</code></td>
    <td>Dietician-specific endpoints</td>
    <td>Dietician Role</td>
  </tr>
</table>

### 📖 Interactive Documentation

<div align="center">
  <a href="http://localhost:8080/swagger-ui.html">
    <img src="https://img.shields.io/badge/Swagger%20UI-Interactive%20API%20Docs-green?style=for-the-badge&logo=swagger" alt="Swagger UI" />
  </a>
</div>

Access the interactive API documentation at: **http://localhost:8080/swagger-ui.html**

## 🤝 Contributing

### Development Workflow
1. Fork the repository
2. Create a feature branch
3. Implement your changes
4. Add tests for new functionality
5. Submit a pull request

### Code Standards
- Follow Java/Kotlin coding conventions
- Write comprehensive tests
- Update documentation
- Use meaningful commit messages

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

For support and questions:
- Create an issue in the repository
- Contact the development team
- Check the documentation

---

**Built with ❤️ using Clean Architecture and Modern Java Technologies**

