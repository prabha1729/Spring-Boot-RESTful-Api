# Spring-Boot-RESTful-Api for Contact System

 This is a spring boot REST API that will enable a client to perform CRUD operations on the contact collection.

# Execution
```
# To build the project standard maven build is sufficient
mvn clean install

# To start/run the project spring boot maven plugin is included just run
mvn spring-boot:run

# The integration test may be executed using
mvn test
```
 # Usage 
Once the application is started,

## To get all the contacts   
- Goto http://localhost:8080/contacts/ which return all contacts available.

## To get specific contact   
- Goto http://localhost:8080/contacts/{id} which return all the information about the contact.

## To add or update a new contact   
- Execute the following in [cURL](https://en.wikipedia.org/wiki/CURL)
```
##For update replace POST to PUT
$ curl -i -X POST -H "Content-Type:application/json" -d "{
    "address": {
        "street": "Barton Creek Drive",
        "city": "Charlotte",
        "state": "North Carolina",
        "zip": "28262"
    },
    "name": {
        "first": "Akhilshetty",
        "middle": "",
        "last": "Madhamshetty"
    },
    "phones": [
        {
            "number": "1234567890",
            "type": "work"
        },
        {
            "number": "9876543210",
            "type": "mobile"
        }
    ],
    "email": "akhil@gmail.com"
}" http://localhost:8080/contacts/

```



