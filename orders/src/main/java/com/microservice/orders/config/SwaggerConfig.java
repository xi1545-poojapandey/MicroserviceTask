package com.microservice.orders.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static io.swagger.models.auth.In.HEADER;
import static java.util.Collections.singletonList;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).
				securitySchemes(singletonList(new ApiKey("AZURE_AD_ACCESS_TOKEN", AUTHORIZATION, HEADER.name())))
				.securityContexts(singletonList(
						SecurityContext.builder()
								.securityReferences(
										singletonList(SecurityReference.builder()
												.reference("AZURE_AD_ACCESS_TOKEN")
												.scopes(new AuthorizationScope[0])
												.build())).build())).select().apis(RequestHandlerSelectors
						.basePackage("com.microservice.orders.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Spring Boot REST API")
				.description("REST API")
				.contact(new Contact("Pooja Pandey", "", "pooja.pandey@xebia.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();

	}
}