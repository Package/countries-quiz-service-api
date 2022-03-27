package com.github.pkg.countryapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.TreeMap;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI getApiDefinition() {
        Contact contact = new Contact()
                .name("Package")
                .url("https://github.com/Package");

        Info info = new Info()
                .title("Quiz Countries Service API")
                .version("v1")
                .description("API for generating questions used in a Quiz App")
                .contact(contact);

        return new OpenAPI().info(info);
    }

    @Bean
    public OpenApiCustomiser sortSchemas() {
        return openApi -> {
            // Sort schemas alphabetically in Swagger UI:
            Components apiComponent = openApi.getComponents();
            Map<String, Schema> schemaMap = apiComponent.getSchemas();
            apiComponent.setSchemas(new TreeMap<>(schemaMap));
        };
    }
}
