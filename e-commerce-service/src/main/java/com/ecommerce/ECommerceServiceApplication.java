package com.ecommerce;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecommerce.dto.ProductWithoutQuantityDTO;

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
		
		/* @Component
		 *   1. @Service
		 *   2. @Repository
		 *   3. @RestController
		 *   4. @Configurationfjnsdjnvcsjnvsjnv
		 * */
		
		
		/* Scope of beans 
		 *  1. Singleton (Default scope)
		 *  2. Prototype
		 *  3. Request
		 *  4. Session
		 *  5. GlobalSession (spring 3.x, 4.x deprecated)
		 * */
		
		double price = 10;
		String name = "tshirt";
		ProductWithoutQuantityDTO DT = new ProductWithoutQuantityDTO(name, 10);
		DT.setPrice(30);
		
		
		DT.setPrice(10);
		
		

	}

	@Bean
	public Docket swaggerConfiguration() { // Return the instance of docket instance
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfor());
	}

	@Bean
	private static ApiInfo apiInfor() {
		return new ApiInfo("Ecommerce WebSite", "Apis of Ecommerce Website. Copyright By Sidharth Das ", "1.0", "Free To Use", "", "", "");
	}
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
