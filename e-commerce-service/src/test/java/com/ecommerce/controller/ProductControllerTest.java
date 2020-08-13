package com.ecommerce.controller;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;



@DisplayName("Testing ProductControllerTest Class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS )
class ProductControllerTest {
	
	ProductController productController;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Before all");
	}
	
	@BeforeEach
	void init() {
		productController = new ProductController();
		
	}
	
	@DisplayName("Testing Nested AddTest Class")
	@Nested
	class AddTest{
		
		@Test
		@DisplayName("Testing add method for positove")
		void testAddPositive() {
			int expected = 3;
			int actual = productController.add(1, 2);
			assertEquals(expected, actual, "It should add two numbers");
		}
		
		@Test
		@DisplayName("Testing test method for negative")
		void testAddNegative() {
			int expected = -6;
			int actual = productController.add(-4, -2);
			assertEquals(expected, actual, "It should add two numbers");
		}
		
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up . . . . ");
	}

	
	
	@Test
	void testComputeCirecleArea() {
		assertEquals(314.1592653589793, productController.computeCircleArea(10), "Should retrive circle area");
	}
	
	@RepeatedTest(5)
	void testDiv() {
		
		boolean isServerUp = false;
		Assumptions.assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> productController.div(10, 0), "Cant be divisible by 0");
		
	}
	
	@Test
	@DisplayName("Multiply Method")
	void testMultiply() {
		Assertions.assertAll(() -> assertEquals(10, productController.multiply(1, 10)),  () -> assertEquals(0, productController.multiply(0, 10)));
		
		
	}
	
	@Test
	@Disabled
	@DisplayName("This test should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	void testEnabled() {
		fail("windows");
	}
	
	

}
