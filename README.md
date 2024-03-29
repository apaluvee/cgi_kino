# Kino App Backend

## Requirements
* Java 17
* PostgreSQL

## Database setup

```
CREATE DATABASE kinoapp;
```

## Configure application properties

`spring.datasource.url` should be the URL of the created DB

`spring.datasource.username` should be the username for the DB

`spring.datasource.password` should be the password for the DB

### Running the application
```
./mvnw spring-boot:run
```

### Troubleshooting
If you dont have permission to run mvn wrapper then you need to add permission to it
```
    chmod +x mvnw