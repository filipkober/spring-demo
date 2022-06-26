# Welcome!

### this is my first java spring boot project. Below I explain how to run it

# Installation:

1. Download postgres sql  
2. Set up the *postgres* account with password *postgres*  
3. Go to the `keycloak-18.0.2` directory and run `./bin/kc.bat start-dev --http-port 8180`
4. (Optional) visit the `http://localhost:8180/` and add users if you want
5. There are two default users: An admin - `filipkober` with password `filip` and a user - `jsrokowski` with password `jakub`
6. Download kafka, configure it and start zookeeper in the kafka directory: `.\bin\windows\zookeeper-server-start.bat ./config/zookeeper.properties` (remove the `\windows\` if you're using a different OS like Mac or Linux)
7. Start kafka server in the same directory: `./bin/windows/kafka-server-start.bat config/server.properties` (remove the `\windows\` if you're using a different OS like Mac or Linux)
8. Build the project with maven: `mvn clean package`
9. Finally start the .jar file in the `target` directory: `java -jar target/spring-boot-kafka-example-1.0-SNAPSHOT.jar`

# Usage:
#### The api URL is: `http://localhost:8080/api/v1`
This is a simple demo app which has the ability to create a new user and read users, depending on your role.

### Available endpoints for user roles:

- `/users/{id}` - GET - returns user with given id
- `/users` - POST body: `{"name": <name>, "email": <email>, "birthDate": <birthdate YYYY-MM-DD>}` - creates a new user

### Available endpoints for admin roles:



- `/users/{id}` - GET - returns user with given id
- `/users` - GET - returns all users
- `/users` - POST body: `{"name": <name>, "email": <email>, "birthDate": <birthdate YYYY-MM-DD>}` - creates a new user

# Request authentication:
To get a token, do the following:

1. Set grant type to **Password Credentials**
2. Set Access Token URL to `http://localhost:8180/realms/spring-demo/protocol/openid-connect/token`
3. Set Client ID to `springboot-keycloak`
4. Set username to either `jsrokowski` or `filipkober`
5. set password to either `jakub` or `filip`
6. Set scope to `openid`
7. Set Client Authentication to **Send as Basic Auth header**

Congratulations, you can now send requests to the API with the token in the Authorization header.

#### Thank you for reading this!
