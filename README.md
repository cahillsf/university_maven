# Containerized Spring Boot Application with Maven
 
## clone the application

open src/main/resources/application.properties

change spring.datasource.url, spring.datasource.username and spring.datasource.password with credentials created in the mysql container setup

open src/main/resources/hibernate.cfg.xml
 update "hibernate.connection.url", "hibernate.connection.username", "hibernate.connection.password" with credentials created in the mysql container setup

cd into the university_maven, build the application using maven command <br/>
<code>mvn package</code>

build the docker image based on the maven package using <br/>
<code>docker build -t spring-example . </code>


run the newly created docker image<br/>
<code>docker run -p 8081:8081 spring-example</code>

Application will start running at http://localhost:8081

## Explore the REST APIs

GET /test/student/  <br/>
GET /test/student/{studentId} <br/>
GET /test/student/{studentId}/enrollments <br/>
GET /test/student/{studentId}/enrollments/{courseId}
