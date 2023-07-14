This is my first API project

I used Springboot and Maven to create a REST API that utilizes the CRUD principles. 

This api can create, read, update, and delete user data which is stored in a MongoDb no-sql database that is run using a Docker container. 

Json Format for User:
{
    "name": "Name", 
    "email": "user@xyz.com"
}

A unique ID is auto generated for each user using the SpringFramework ID annotation. 

The api is hosted on localhost:8085

Create (POST):
http://localhost:8085/api/create

Read (GET):
http://localhost:8085/api/users
http://localhost:8085/api/users/{id}    

Update (PUT): 
http://localhost:8085/api/users/{id}


Delete (DEL):
http://localhost:8085/api/users/{id}