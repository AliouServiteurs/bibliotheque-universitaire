package com.leserviteurs.sn.bibliotheque.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bibliothequeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("📚 API de Gestion de Bibliothèque Universitaire")
                        .description("Cette API permet de gérer les abonnés, les livres, les emprunts et les retours dans une bibliothèque universitaire.\n\n"
                                + "Toutes les opérations CRUD sont disponibles, ainsi que les fonctionnalités d'import/export CSV et PDF.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Les Serviteurs")
                                .email("support@leserviteurs.sn")
                                .url("https://leserviteurs.sn"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
