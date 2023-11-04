# Section 11 notes: JPA and Hibernate introduction

## @PersistenceContext
- @PersistenceContext is more specific than @Autowired
- E.g. use with EntityManager and JPA (see CourseJpaRepository.java)

## JDBC -> JPA -> Spring Data JPA
- JDBC is more complex than JPA, and JPA is more complex than Spring Data JPA
  - **JDBC**
    - Offers more fine-grained control with database interactions, but queries can become complex
  - **JPA**
    - Allows developers to work with Java objects (define entity classes and configure mapping), instead of writing SQL queries
    - Makes use of EntityManager interface (methods include .merge() for inserting, .find(), and .remove())
  - **Spring Data JPA**
    - Reduce manual configuration by providing repository interfaces to help with common use cases for data accessing
    - EntityManager is abstracted away
    - Provides features like query methods, which generate SQL queries based on method names