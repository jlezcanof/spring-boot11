call mvn clean verify install sonar:sonar

:: Clean (for avoiding the 'generated-sources' issue)
:: call .\mvnw clean
if not "%ERRORLEVEL%" == "0" exit /b
