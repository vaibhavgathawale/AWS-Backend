package com.iiht.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket stockCommandApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.iiht.company.controller"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        Contact contact = new Contact("E-Stock Market", "https:www.findme.co", "nikhilrajput@gmail.com");
        return new ApiInfoBuilder()
                .title("REST APIs to Add/Get/Delete company")
                .version("1.0")
                .contact(contact)
                .build();
    }
}
