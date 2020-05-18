package edu.lez.boot8java11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/*import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;*/


/**
 * <br>
 * ·Read this url for more configurations for openAPI 3:
 * https://springdoc.org/springdoc-properties.html
 * https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md
 * https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-springdoc-openapi-3/ 
 * <br>
 */
@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        
        
        /*return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors
        .basePackage("edu.lez.boot8java11.rest"))
        // Exclude '/monitor' operations
        .paths(PathSelectors.regex("(?!/monitor).+"))
        // Exclude Activiti operations
        .paths(PathSelectors.regex("(?!/api/ui/v1).+")).paths(PathSelectors.regex(
            "(?!/start-hire-process).+")).paths(PathSelectors.regex("(?!/version).+")).paths(
                PathSelectors.regex("(?!/favicon).+")).paths(PathSelectors.regex(
                    "(?!/management).+")).paths(PathSelectors.regex("(?!/repository).+")).paths(
                        PathSelectors.regex("(?!/query).+")).paths(PathSelectors.regex(
                            "(?!/form).+")).paths(PathSelectors.regex("(?!/identity).+")).paths(
                                PathSelectors.regex("(?!/history).+")).paths(PathSelectors.regex(
                                    "(?!/process-definition).+")).paths(PathSelectors.regex(
                                        "(?!/runtime).+")).paths(PathSelectors.regex(
                                            "(?!/auditevents).+")).paths(PathSelectors.regex(
                                                "(?!/error).+")).paths(PathSelectors.regex(
                                                    "(?!/env).+")).paths(PathSelectors.regex(
                                                        "(?!/testws).+"))*/
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Example Application API").description(
                        "This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
    }
}
