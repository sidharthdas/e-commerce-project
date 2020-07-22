package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
//@Enable
public class ECommerceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceServiceApplication.class, args);
		
	
	}

}
