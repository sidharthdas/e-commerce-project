package com.ecommerce.controller;

import org.junit.jupiter.api.Test;

class ProductControllerTest {

	@Test
	void test() {
		ProductController productController = new ProductController();
		
		int expected = 2;
		
		int actual = productController.add(1, 2);
		
		//assertEquals(expected,actual );
	}

}
