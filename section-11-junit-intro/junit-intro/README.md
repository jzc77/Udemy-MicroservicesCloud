# Section 11 notes: JUnit introduction

- JUnit does not guarantee that tests run in order in your test file
- The @BeforeAll and @AfterAll need to be static because these are class level methods. They are ran before/after all the tests.