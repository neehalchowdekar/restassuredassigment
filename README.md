# restassuredassignment

Restassured assignment built using Restassured, Java, Maven, Testng

**Test Driven Framework**

How to use this framework ? 

Clone the repository to your workspace

1. Open CMD/terminal check for maven 
    
    ```bash
    mvn -v
    ```
    
2. Run this command from the workspace path

```bash
           mvn clean install test 
```

**How framework works ?**

1. The framework is created using restassured framework, using RequestSpecification and ResponseSpecification which will allow how the request and response looks like.
2. Created the request body using builder anotation and also used jacksonized which It automatically configures the generated builder class to be used by Jackson's deserialization.
3. For Assertions used hamcrest library, asserted the response body with respect to the response body and also status code, header.
4. Used Data provider to drive the test with given json file using jackson api ObjectMapper class and enabled the parallel execution.

**com.reqres.applicationApi.SpecBuilder :** This class has getRequestSpec method which returns RequestSpecification Interface using RequestSpecBuilder setting the baseUri(Owner library to fetch the uri), basePath(Route class to fetch the path), content type, log

It has getResponse to fetch response specification

 **com.reqres.applicationApi.RestResource**: Here defining restassured given, when, then method to get the response and return it.

**com.reqres.applicationApi.UserApi :** User defined UserApi class will have get,post method with Users class as parameter it will return the response.

**com.reqres.pojo.Users:**  This is POJO class with request and response data used lombok annotations
