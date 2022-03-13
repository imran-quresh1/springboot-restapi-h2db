##Author
Imran Qureshi

## Description
A simple spring boot application with POST and GET endpoints to create and retrieve a customer using H2 in-memory database.

##Built with
jdk-11.0.2
Spring Boot v2.6.4

##Pre-requisite
Create a database file called myh2.mv.db in your user root folder. 

##H2 console:
http://localhost:8080/h2-console/

Clicking on Test Connection button should make a successful connection if above file is created.

##OpenAPI spec 
http://localhost:8080/techtest-imran/v3/api-docs

##Build
Run following command from your project's root folder:

./mvnw clean install

This should have produced a following jar file under project's root folder:

target/tech-test-0.0.1-SNAPSHOT.jar

##Run
Make sure you have run the build step above to produce a target folder and a jar.

Run following command from project's root folder to run application:

java -jar target/tech-test-0.0.1-SNAPSHOT.jar

##Endpoints

###1. 
POST localhost:8080/techtest-imran/customers/

Body:

```json
{
    "firstname": "Imran",
    "lastname": "Qureshi",
    "dateOfBirth": "1980-01-01"
}
```

###2.

GET localhost:8080/techtest-imran/customers/1

##Testing
From postman first call the POST endpoint above to create a customer passing in json for customer.

And then call GET endpoint to see the created customer.
