package com.udemy.learn.blogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
info=@Info(
		title="spring boot blogging rest api",
		description="Description of spring boot",
		version="v1.0.0",
		contact=@Contact(
				name="Saroj Chalise",
				email="chalise@gmail.com",
				url="https://tradengine.com.np"
				),
		license=@License(
				name="Apache 2.0",
				url="https://tradengine.com.np")
		
		)
)
public class BloggingApplication {


	public static void main(String[] args) {
		SpringApplication.run(BloggingApplication.class, args);
	}

}
