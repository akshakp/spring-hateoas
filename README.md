# spring-hateoas

This is an example of Spring Hateoas implementation with Spring Boot 2.2 and JAVA 8 Stream APIs.
Link to the details will be returned in the result for active users. Users marked as "active : false" will be returned without link.

```

{
    "firstName": "User",
    "lastName": "3",
    "email": "user3@test.com",
    "id": 3,
    "active": true,
    "_links": {
        "details": {
            "href": "http://localhost:8080/users/3"
        }
    }
},
{
    "firstName": "User",
    "lastName": "4",
    "email": "user4@test.com",
    "id": 4,
    "active": false
}

```

### build

```
mvn package
```

### run

```
mvn spring-boot:run
```

Example has Spring Boot devtools for live reload.

Share your comments/suggestions : ron.m.patel@gmail.com
