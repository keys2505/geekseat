package com.geekseat.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApiInfo() {
        return new OpenAPI()
                .info(new Info().title("Geekseat API")
                        .description("Geekseat API Documentation")
                        .version("v0.0.1").contact(contact())
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Geekseat API Documentation")
                        .url("https://memos.co.id"));
    }

    private Contact contact() {
        var contact = new Contact();
        contact.setEmail("keys2505@gmail.com");
        contact.setName("Eri Yudisastrawan");
        return contact;
    }
}
