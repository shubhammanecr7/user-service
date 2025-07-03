package com.skvm.user_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        //Define server environment
        Server devServer = new Server();
            devServer.setUrl("http://localhost:8080");
            devServer.setDescription("user-service spring-boot app for user management DEV.ENV");

        Server prodServer = new Server();
            prodServer.setUrl("http://company.com/api/v1/users");
            prodServer.setDescription("user-service PROD.ENV");

        //Contact information
        Contact contact = new Contact();
            contact.setName("SHUBHAM MANE");
            contact.setUrl("http://shubham.java.dev");
            contact.setEmail("mrjava@shubham.com");

        //Licence information
        License license = new License();
            license.name("MIT Licence");
            license.url("http://license.com");

        // API Info
        Info info = new Info();
            info.title("users-service rest.crud");
            info.version("1.1.0");
            info.description("Users management crud rest apis");
            info.termsOfService("https://company-website.com/terms");
            info.contact(contact);
            info.license(license);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer,prodServer));
    }
}