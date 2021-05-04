package com.jump.jump.config;


import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig  {	
	
	@Bean
	public Docket getSwaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jump.jump"))
				.paths(PathSelectors.ant("/**"))
				.build();
	}

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Imobiliaria API REST",
                "API REST de cadastro de Imobiliar.",
                "1.0",
                "Terms of Service",
                new Contact("Gabriel Erick Silva ", "https://www.linkedin.com/in/gabriel-erick-silva/",
                        "gabrielericksilva@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }

   
}
