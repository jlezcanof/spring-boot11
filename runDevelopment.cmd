:: runDevelopment, for H2 DBMS

   @echo "Connecting to an in-memory H2 DBMS
   @REM ::Run the Spring Boot app using a H2 in-memory database (intended for developers only)
   call mvn clean
   if not "%ERRORLEVEL%" == "0" exit /b
   mvn spring-boot:run -Dspring-boot.run.arguments=--spring.config.location=file:./src/test/resources/
   ::mvnDebug spring-boot:run -Dspring-boot.run.arguments=--spring.config.location=file:./src/test/resources/
   @REM echo "one"

