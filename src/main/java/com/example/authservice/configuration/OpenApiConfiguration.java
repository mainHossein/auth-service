package com.example.authservice.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Authentication Service API",
                version = "1.0.0",
                description = "REST API for authentication and authorization manager"
        )
)
public class OpenApiConfiguration {

        @Bean
        public OpenAPI openAPI() {
                final String securitySchemaName = "BasicAuth";
                return new OpenAPI()
                        .components(
                                new Components()
                                        .addSecuritySchemes(
                                                securitySchemaName,
                                                new SecurityScheme()
                                                        .type(SecurityScheme.Type.HTTP)
                                                        .scheme("basic")
                                        )
                        )
                        .addSecurityItem(new SecurityRequirement().addList(securitySchemaName));
        }
}
