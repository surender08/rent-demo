package com.databasetesting.mydata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@SpringBootApplication
@EnableJpaRepositories
public class RentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentDemoApplication.class, args);
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${app.title}") String appTitle,
			@Value("${app.description}") String appDesciption, @Value("${app.version}") String appVersion) {

		return new OpenAPI().info(new Info().title(appTitle).version(appVersion).description(appDesciption)
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}


}
