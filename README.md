# Vitalis - Patient Tracking System

Vitalis is an enterprise software solution designed to facilitate patient tracking and ensure the secure management of patient data. The project is developed with modern software engineering principles and is divided into four main modules: API, Data, Service, and Common. It is built using Spring Boot and Kotlin and operates on a MySQL database.

## Modules

- **API**: This module serves as the RESTful API layer of the application, allowing accounts and clients to access data.
- **Data**: The Data module handles database interactions and defines data models. It uses JPA (Java Persistence API) to perform database operations.
- **Service**: This module is where the business logic is implemented. It defines the business rules and processes data.
- **Common**: The Common module contains shared DTOs (Data Transfer Objects) and utility classes used across the project.

## Features

- Create, update, and delete patient records
- Secure storage of medical information
- User roles and permission management
- Modular development structure suitable for enterprise applications

## Technologies

- **Backend**: Spring Boot
- **Database**: MySQL
- **Build System**: Gradle Kotlin DSL
- **Dependency Injection**: Spring DI (Dependency Injection)
- **Database Interaction**: Spring Data JPA, Hibernate
- **API Documentation**: Springdoc OpenAPI

## Setup

### Recommended Tools and Requirements

- JDK 17+
- Gradle 7+
- MySQL


- [IntelliJ IDEA](https://www.jetbrains.com/idea/download) as the Integrated Development Environment (IDE).
- [XAMPP](https://www.apachefriends.org/tr/download.html) for running the MySQL server on a local machine.

The following instructions prepared with these tools in mind.
### Clone the Repository

   ```bash
   git clone https://github.com/your-username/vitalis.git
   cd vitalis
  ```

### Setting Up the IDE
Ensure that you have the latest JDK and JRE installed on your machine. To allow IntelliJ to resolve project files and scripts, follow these steps:
- Go to `File > Project Structure`.
- 	In the SDK section, download **JetBrains Runtime 17**.
-	Set the Language **Level to 17 - Sealed types, always-strict floating-point semantics**.

### Setting Up the MySQL Server
- Install [XAMPP](https://www.apachefriends.org/tr/download.html) on your machine.


- Open the **XAMPP UI** and click the Go to Application button. This will open `localhost/dashboard` in your browser. Navigate to `localhost/phpmyadmin`.


### Creating Database and User Account
- Create a new database named `vitalis_database`.


- In `localhost/phpmyadmin`, create a new User Account. **Ensure that the credentials match those in your Spring Boot application** (found in `vitalis/src/main/resources/application.properties`). Grant the User Account all global privileges, and do not check any boxes under "Database for account account."


- After creating your User Account, you may notice one or two anonymous accounts created by XAMPP by default. To successfully access your database, drop these anonymous accounts, as they can interfere with your real account.


With these steps, you should be able to build the project without any issues. If you're still unable to build the project successfully, you may need to check the XAMPP server's configuration files. For further questions, feel free to reach out to us.

