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

## extends and @Override
- When I extend "ResponseEntityExceptionHandler", I can use @Override annotation to override a method in the ResponseEntityExceptionHandler class.
- The @Override annotation is to "[indicate] that a method declaration is intended to override a method declaration in a supertype."

## Advanced REST API features
- **Documentation**
  - springdoc-openapi - Java library that helps to automate the generation of API documentation using spring boot projects
- **Content negotiation**
  - Enables client to specify what type of data to receive (e.g. JSON or XML)
  - Client specifies this in Accept header (e.g. Accept header value can be "application/xml")
- **Internationalization (i18n)**
  - Enables client to specify what language of data to receive
  - Makes use of MessageSource class, messages.properties, and Accept-Language header (see /helloworld/HelloWorldController.java)
- **Versioning**
  - Used when you need to implement a breaking change to your REST API for your clients
  - Different types of versioning options:
    - URL (used by Twitter)
    - Request parameter (used by Amazon)
    - Header (used by Microsoft)
    - Media Type (used by GitHub)
- **HATEOAS**
  - Hypermedia as the Engine of Application State
  - In addition to returning data in response body, we can use HATEOAS to return links that tell consumers how to perform subsequent actions.
  - E.g. Along with retrieving a user's name and birthdate in the response via `http://localhost:8080/users/{id}`, you can also include a link in the response to retrieve all users (e.g. `http://localhost:8080/users`)
  - Makes use of EntityModel and WebMvcLinkBuilder in controller class (see UserController.java)
- **Static filtering**
  - Excluding or filtering out specific fields or properties from the response data
  - Useful when fields are not relevant for clients or contain sensitive info
  - Use @JsonIgnoreProperties, @JsonIgnore
- **Dynamic filtering**
  - Allows clients to specify which fields they want to include or exclude in the API response
  - Gives clients more control over the data they receive
  - Use @JsonFilter with FilterProvider
- **Monitoring**