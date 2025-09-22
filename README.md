# Spring Security Demo

This project is a sample API using **Spring Boot 3.5.5**, **Spring Security**, JWT, and MySQL. It includes JWT-based authentication, user management, and validation handling.

## Requirements

- Java 17+
- Maven 3.8+
- MySQL

## Configuration

Before running the project, you must create the `src/main/resources/application.properties` file with the following structure:

```properties
spring.application.name=spring_security

# Data Base Connection
db.host=localhost
db.port=3306
db.name=spring_security
db.username=root
db.password=root

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true

# Secret Key
jwt.secret=YOUR_SECRET_KEY_HERE
```

> **Note:**  
> For the `jwt.secret` value, you must generate a secure 256-bit key.  
> You can easily generate one at:  
> [https://jwtsecrets.com/tools/encryption-key-generator](https://jwtsecrets.com/tools/encryption-key-generator)  
> Select **256 bits** and copy the generated key into the corresponding field.

## Running the Project

1. Clone the repository.
2. Create the database in MySQL with the name defined in `db.name`.
3. Configure the `application.properties` file as shown above.
4. Run the project with:

```sh
./mvnw spring-boot:run
```
or
```sh
mvn spring-boot:run
```

## Main Endpoints

- `/api/v1/auth/**` — Authentication endpoints (login, register, etc.)
- `/api/v1/demo/**` — Example protected endpoints

---
