package org.shop.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SpringFoxConfig {    
	public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())  
          .select()       
          .apis(RequestHandlerSelectors.basePackage("org.shop.controller"))     
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    private ApiInfo getApiInfo() {
        return new ApiInfo(
          "Online Shop Discount API", 
          "Bill Discount API", 
          "Shop", 
          "Terms of service", 
          new Contact("Kamel HADDAD", "www.google.com", "k.haddad.job@gmail.com"), 
          "License of API", "https://choosealicense.com/licenses/agpl-3.0/", Collections.emptyList());
    }
    
   

    
}