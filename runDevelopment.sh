# ::Run the Spring Boot app using a H2 in-memory database (intended for developers only)
./mvnw clean
./mvnw spring-boot:run -Dspring.config.location=src/test/resources/application.properties

