# Section 12 notes: Mockito introduction

### General
- Mockito is already supplied as a dependency in a Spring Initializr project. The artifactId is "spring-boot-starter-test" in pom.xml.
- The effective POM is used to see the final dependencies of a project.
  - Right-click on a module in the Project pane > go to Maven > Show Effective POM

### Stubs vs Mocks
- Stub: A class that have methods which return a pre-determined response
- Mock: A stub with an assertion

### Errors and fixes
- `java.lang.NullPointerException: Cannot invoke "com.jc.mockito.mockitointro.business.DataService.retrieveAllData()" because "this.dataServiceMock" is null
  `
  - In the test class, add `@ExtendsWith(MockitoExtension.class)`