package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableSwagger2
@EnableScheduling
@EnableTransactionManagement
public class ECommerceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceServiceApplication.class, args);

	}

	@Bean
	public Docket swaggerConfiguration() { // Return the instance of docket instance
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfor());
	}

	@Bean
	private static ApiInfo apiInfor() {
		return new ApiInfo("Ecommerce WebSite", "Apis of Ecommerce Website. Copyright By Sidharth Das ", "1.0", "Free To Use", "", "", "");
	}

}
