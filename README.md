# UserService

RESTful API in Java Spring Boot, which supports operations on a `User` entity.

## Requirements:

* Java Development Kit (JDK) 11 or later
* Apache Maven
* Docker
* Docker Compose

## Build and Run

In the project root:

```shell
mvn clean package
docker compose up -d --build
```

Access the API:

`http://localhost:8080/api/users`
