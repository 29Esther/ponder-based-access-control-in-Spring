# A quarter project
Spring Boot + Spring Security + Keycloak

### Components
1. The OAuth2 Authorization Server
an embedded Keycloak server in a Spring Boot app as Authorization Server
2. Resource Server
a spring boot application with MVC model and Spring Data Rest
3. A Library
a Custom Spring AOP Annotation to provide authorization check


### Build Steps
1. Start the OAuth2 authorization server
```
cd jwt-auth-server
mvn clean spring-boot:run
```
Then, you could hit http://localhost:8083/auth to do the configuration
```
Username: admin
Password: admin
```

2. Build the library
```
cd ponder-library
mvn clean install
```

3. Run the resource application
```
cd jwt-resource-server 
mvn clean spring-boot:run
```

### Test Steps
1. generate jwt token
```
curl -i -X POST \
   -H "Authorization:Basic and0Q2xpZW50OmFlYWQ4ZWI2LWZiNTAtNDUwZC1iN2Y3LTFkYTZjYzkzOTIxZQ==" \
   -H "Content-Type:application/x-www-form-urlencoded" \
   -d "client_id=jwtClient" \
   -d "username=user1" \
   -d "password=user1" \
   -d "grant_type=password" \
 'http://localhost:8083/auth/realms/ecs235/protocol/openid-connect/token'
```
get `access_token`

2. test the apis
* Spring data rest: `http://localhost:8081/app/` 
* Other api: `http://localhost:8081/app/api/v1/**`