# Spring Boot + JPA and Hibernate + PostgreSQL RESTful CRUD API demo project
</br>Ignat Malouhov, 03.2023

## Introduction
I`m exited to introduce you my journey through Java and Spring technologies to Software Engineer knowledge and experience.
I prefer to dig into all possible advantages / disadvantages when write every line of code.

## Running application locally
You can build a jar file and run it from the command line (it should work just as well with Java 17 or newer):
```
git clone https://github.com/malouhov/crud-rest-api-demo.git
cd crud-rest-api-demo
./mvnw package
java -jar target/*.jar
```

You can then access my application at http://localhost:8080/
Or you can run it from Maven directly using the Spring Boot Maven plugin:
```
./mvnw spring-boot:run
```

> NOTE: Windows users should set `git config core.autocrlf true` to avoid format assertions failing the build (use `--global` to set that flag globally).

> NOTE: If you prefer to use Gradle, you can build the app using `./gradlew build` and look for the jar file in `build/libs`.

## Description
The following are the endpoints of API:</br>

| Method | Path           | Description            |            
|--------|----------------|------------------------|
| POST   | /api/v1/..     | create new ...         |
| UPDATE | /api/v1/.../id | update ... by {id}     |
| GET    | /api/v1/...s   | retrieve all ...       |
| DELETE | /api/v1/...s   | delete all ...         |
| GET    | /api/v1/.../id | retrieve a ... by {id} |
| DELETE | /api/v1/.../id | delete a ... by {id}   |

## Database configuration
My application use PostgreSQL database. You can create database locally using:
```
createdb -h localhost -p 5432 -U postgres crud-rest-api-demo-database
password ****
```

## Project backlog
1. MVP: Customer Entity, Service, Repository, Controller and database setup.
2. Test Repository and Controller
3. Add two entities Account + Cashback and implement JPA One-To-Many + Many-To-Many mapping
4. Loading initial data to the database using data.sql
4. Add complex queue with JOIN to the Repository, Service and Controller
5. Refactor Controller using DTO and implement MapStruct mapper
6. Add validation to the Controller
7. Handle rest exceptions using ExceptionHandler
8. Dockerize application

## Technologies

## References
1. [Walls, Craig (2022). Spring in Action, Sixth Edition. Manning Publications. ISBN 9781617297571](https://www.manning.com/books/spring-in-action-sixth-edition)</br>
2. [The Clean Architecture by Robert Martin](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)</br>
3. [Spring Boot Reference Documentation section Using Spring Boot chapter 2. Structuring Your Code](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.structuring-your-code)</br>
4. [Spring Boot Best Practices for Developers](https://medium.com/@raviyasas/spring-boot-best-practices-for-developers-3f3bdffa0090)</br>
5. [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)</br>
6. [Lombok & Hibernate: How to Avoid Common Pitfalls](https://thorben-janssen.com/lombok-hibernate-how-to-avoid-common-pitfalls/)</br>
7. [Ultimate Guide to Implementing equals() and hashCode() with Hibernate](https://thorben-janssen.com/ultimate-guide-to-implementing-equals-and-hashcode-with-hibernate/)</br>