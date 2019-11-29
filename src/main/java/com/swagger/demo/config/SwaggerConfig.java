package com.swagger.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.swagger.demo")) //.paths(regex("/api/*")).build()
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {

		ApiInfo apiInfo = new ApiInfo("Spring Boot Swagger2 Demo", "Spring Boot Swagger2 Demo Application", "1.0.0",
				"Terms of Service url", "Rahul G", "Built using SpringBoot(2.1.6) and Swagger(2.9.2)", "https://start.spring.io/");

		return apiInfo;
	}
}
