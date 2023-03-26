# Spring Boot + JPA and Hibernate + PostgreSQL RESTful CRUD API demo project

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

| Method | Path            | Description                                  |            
|--------|-----------------|----------------------------------------------|
| POST   | /api/v1/...s    | create new ...                               |
| GET    | /api/v1/...s/id | retrieve a ... by {id}                       |
| GET    | /api/v1/...s    | retrieve all ...                             |
| PUT    | /api/v1/...s/id | update a ... by {id}                         |
| DELETE | /api/v1/...s/id | delete a ... by {id}                         |
| DELETE | /api/v1/...s    | delete all ...                               |

## Database configuration
My application use PostgreSQL database. You can create database locally using:
```
createdb -h localhost -p 5432 -U postgres crud-rest-api-demo-database
password ****
```

## Project backlog
:ok_hand: MVP: Customer Entity, Service, Repository, Controller and database setup</br>
:ok_hand: Test Repository and Controller</br>
:construction_worker: Override equals() and hashCode() + test using github.com/jqno/equalsverifier</br>
:construction_worker: Implement JPA One-To-Many + Many-To-Many mapping</br>
:construction_worker: Loading initial data to the database using data.sql</br>
:construction_worker: Add complex queue with JOIN to the Repository, Service and Controller</br>
:construction_worker: Refactor Controller using DTO and implement MapStruct mapper</br>
:construction_worker: Add validation to the Controller</br>
:construction_worker: Handle rest exceptions using ExceptionHandler</br>
:construction_worker: Add logging using AOP</br>
:construction_worker: Dockerize application</br>

## Technologies
* Java 17
* Spring Boot
* Hibernate

## References
1. [Walls, Craig (2022). Spring in Action, Sixth Edition. Manning Publications. ISBN 9781617297571](https://www.manning.com/books/spring-in-action-sixth-edition)</br>
2. [The Clean Architecture by Robert Martin](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)</br>
3. [Spring Boot Reference Documentation section Using Spring Boot chapter 2. Structuring Your Code](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.structuring-your-code)</br>
4. [Spring Boot Best Practices for Developers](https://medium.com/@raviyasas/spring-boot-best-practices-for-developers-3f3bdffa0090)</br>
5. [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)</br>
6. [Lombok & Hibernate: How to Avoid Common Pitfalls](https://thorben-janssen.com/lombok-hibernate-how-to-avoid-common-pitfalls/)</br>
7. [Ultimate Guide to Implementing equals() and hashCode() with Hibernate](https://thorben-janssen.com/ultimate-guide-to-implementing-equals-and-hashcode-with-hibernate/)</br>
8. [Hibernate @NotNull vs @Column(nullable = false)](https://www.baeldung.com/hibernate-notnull-vs-nullable)</br>
9. [Unit Testing with Spring Boot article series](https://reflectoring.io/unit-testing-spring-boot/)</br>
10. [Spring Boot MockMVC Example](https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/)</br>
10. [LIKE Queries in Spring JPA Repositories](https://www.baeldung.com/spring-jpa-like-queries)</br>