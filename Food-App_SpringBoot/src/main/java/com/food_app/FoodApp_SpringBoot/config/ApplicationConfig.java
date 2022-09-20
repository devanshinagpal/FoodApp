package com.food_app.FoodApp_SpringBoot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configurable
public class ApplicationConfig {

	@Bean
	public Docket getDocket() {
		
		Contact contact = new Contact("clarivate Global Team", "https://clarivateglobal.com/",
				"test@clarivateglobal.com");

		@SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtensions = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("FoodApp RESTful Web Service documentation",
				"This has list all the end points for clarivateglobal FoodApp application", "1.0",
				"https://clarivateglobal.com/services/software-development/", contact, "Apache 2.0",
				"https://clarivateglobal.com/services/software-development/", vendorExtensions);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.clarivate.swaggerimplementation")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}
}

//@ApiResponses(value = { @ApiResponse(code = Status_Code, message = "Message")})
//@PostMapping(value = "/users", consumes = {MediaType.APPLICATION_XML_VALUE,
//			MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,
//					MediaType.APPLICATION_JSON_VALUE})
