package com.datafoundry.sectionextractor;


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

/*
 * Reference: https://www.vojtechruzicka.com/documenting-spring-boot-rest-api-swagger-springfox/
 * Perfoms configuration needed to show REST API documentation.
 * Use http://<server_name|localhost>:<port_number>/swagger-ui.html#/section-extractor-controller
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.datafoundry"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("Section Extractor API", 
				"Helps users to extract sections from a Word document that is in an SPL format", 
				"API TOS", "Terms of service", 
				new Contact("Avigo Solutions LLC", "https://www.datafoundry.ai/", "sales@dfoundry.io"), "", "",
				Collections.emptyList());
	}

}

