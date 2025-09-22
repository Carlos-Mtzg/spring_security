# Spring Security Demo

Este proyecto es una API de ejemplo utilizando **Spring Boot 3.5.5**, **Spring Security**, JWT y MySQL. Incluye autenticación basada en tokens JWT, manejo de usuarios y validaciones.

## Requisitos

- Java 17+
- Maven 3.8+
- MySQL

## Configuración

Antes de ejecutar el proyecto, debes crear el archivo `src/main/resources/application.properties` con la siguiente estructura:

```properties
spring.application.name=spring_security

# Data Base Connection
db.host=localhost
db.port=3306
db.name=spring_security
db.username={TU_USER_AQUI}
db.password={TU_PASSWORD_AQUI}

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true

# Secret Key
jwt.secret=TU_SECRET_KEY_AQUI
```

> **Nota:**  
> Para el valor de `jwt.secret` debes generar una clave segura de 256 bits.  
> Puedes generarla fácilmente en:  
> [https://jwtsecrets.com/tools/encryption-key-generator](https://jwtsecrets.com/tools/encryption-key-generator)  
> Selecciona **256 bits** y copia la clave generada en el campo correspondiente.

## Ejecución

1. Clona el repositorio.
2. Crea la base de datos en MySQL con el nombre que definas en `db.name`.
3. Configura el archivo `application.properties` como se indica arriba.
4. Ejecuta el proyecto con:

```sh
./mvnw spring-boot:run
```
o
```sh
mvn spring-boot:run
```

## Endpoints principales

- `/api/v1/auth/**` — Endpoints de autenticación (login, registro, etc.)
- `/api/v1/demo/**` — Endpoints de ejemplo protegidos

---
