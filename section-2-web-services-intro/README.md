# Section 2 notes: Web services introduction

## Message exchange format
- XML or JSON

## Transport
- Defines how a service is called
- There are two formats:
   1. **HTTP**
      - When the service is exposed over the internet and accessed via a URL
   2. **MQ**
      - When the service is exposed over a queue
      - The service requester will place a message in the queue and the service provider will listen to the queue. When there is a request on the queue, the service provider will take the request, process it, create a response, and put it back in the queue. The service requester will get the response.

## Web service groups
SOAP and REST are not really comparable
- **SOAP-based** (Simple Object Access Protocol)
  - Uses XML as the request exchange format and SOAP poses restrictions on the XML format
  - The XML request and response structure must consist of a SOAP envelop, which contains an optional SOAP header (contains meta info such as authentication, authorization, signatures) and a SOAP body (content of your request or response)
    ![image](https://github.com/jzc77/Udemy-MicroservicesCloud/assets/121918523/c634aefe-77a5-4bae-a1c6-2b37e81e1c78)
    ![image](https://github.com/jzc77/Udemy-MicroservicesCloud/assets/121918523/6fee9e9b-c1e0-45dc-b3b3-939a7947022f)
  - Can use SOAP over HTTP or over MQ
  - Service definition is usually done with WSDL (Web Service Definition Language)

- **REST-styled** (REpresentational State Transfer)
  - An architectural approach
  - HTTP request methods: GET, POST, PUT, DELETE etc.
  - HTTP response status codes: 200, 404 etc.
  - Key REST abstraction is "resource"
      - A resource has a URI (Uniform Resource Identifier). Assign a URI to each resource.
          - /user/Ranga/todos/1 = the URI to Ranga's first to-do item resource
          - /user/Ranga/todos = the URI to all of Ranga's to-dos resource
          - /user/Ranga = the URI to the resource 'Ranga'
      - A resource can have different representations: XML, HTML, JSON
  - Transport is only HTTP
  - No standard service definition
