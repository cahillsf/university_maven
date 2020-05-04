# university_maven
 
clone the application

open src/main/resources/application.properties

change spring.datasource.url, spring.datasource.username and spring.datasource.password with credentials created in the mysql container setup

open src/main/resources/hibernate.cfg.xml
 update "hibernate.connection.url", "hibernate.connection.username", "hibernate.connection.password" with credentials created in the mysql container setup

cd into the university_maven, build the application using maven command
mvn package

build the docker image based on the maven package using 
docker build -t spring-example .


run the newly created docker image
docker run -p 8081:8081 spring-example

Application will start running at http://localhost:8081

Explore the REST APIs

GET /test/student/  
GET /test/student/{studentId}
GET /test/student/{studentId}/enrollments
GET /test/student/{studentId}/enrollments/{courseId}
