# Section 3 notes: restful web services

## Starter projects
- The starter projects (e.g. Spring Boot Starter Web) brings in all the dependencies (e.g. Spring, Spring MVC, Jackson, Tomcat) for use.
- Spring Boot auto-configures the rest by looking at the class path, all the classes in the class path, and jars. E.g. It autoconfigures Tomcat server, dispatcher servlet, bean-to-json conversion, and an error page.

## Dispatcher servlet
- Any request that is made to the server goes through the dispatcher servlet. The dispatcher servlet then reroutes the
request to the appropriate controller method.

## PUT vs PATCH HTTP methods
- **PUT**: 
  - used to update or replace an entire resource at a specific URL
  - idempotent (multiple requests have the same effect as a single request)
- **PATCH**:
  - used to apply partial modifications to a resource
  - idempotent (multiple requests have the same effect as a single request)

## Static blocks
- A static block, also known as a "static initializer," is a special type of block that is used to initialize static variables in a class.
- The block is executed only once when the class is loaded into memory (executed before the class's constructor or any other method)
- ```
  // Basic syntax of a static block
  
  public class MyClass {
    static {
        // Static initialization code goes here
    }

    // Other class members (fields, methods, constructors) go here
  }
  ```

## ++usersCount vs usersCount++
- **++usersCount**
  - Increments value of usersCount by 1 __before__ the value is used in an expression
- **usersCount++**
  - Increments value of usersCount by 1 __after__ the value is used in an expression