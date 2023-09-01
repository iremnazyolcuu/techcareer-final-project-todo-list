package com.iremnazyolcu.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfigBean {

    @Bean
    public OpenAPI openAPIMethod() {
        return new OpenAPI()
                .info(
                        new Info()
                                .description("Todo List")
                                .version("v1")
                                .contact(new Contact().email("iremnazyolcu@gmail.com").url("url"))
                                .title("Iremnaz Todo List | Final Project")
                                .termsOfService("Iremnaz INC")
                                .license(new License().url("http://www.").name("name")));
    }

}