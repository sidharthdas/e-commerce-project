package com.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO; 

	@Override
	public void addDummyProduct() {
		// TODO Auto-generated method stub
		List<ProductDTO> allProduct = new ArrayList<>();
		allProduct.add(new ProductDTO("T-Shirt", 2999, 10));
		allProduct.add(new ProductDTO("Pant", 4999, 100));
		allProduct.add(new ProductDTO("Shoes", 10999, 110));
		allProduct.add(new ProductDTO("Bag", 2000, 210));
		allProduct.add(new ProductDTO("Underwear", 299, 150));
		allProduct.add(new ProductDTO("Tie", 2999, 610));
		allProduct.add(new ProductDTO("Soap", 20, 180));

		allProduct.forEach(product ->{
			addProduct(product);
		});
		
		
	}

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		if(Objects.isNull(productDTO)) {
			return null;
		}
		if(productDAO.countProduct(productDTO.getProdName()) == 0) {
			Product product = new Product();
			product.setProdName(productDTO.getProdName());
			product.setPrice(productDTO.getPrice());
			product.setProductQuantity(productDTO.getProductQuantity());
			 productDAO.save(product);
			 return productDTO;
		}
		return null;
	}

	@Override
	public List<ProductDTO> addListOfProduct(List<ProductDTO> products) {
		// TODO Auto-generated method stub
		return null;
	}

}
