package com.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.comparator.SortProduct;
import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.dto.SearchForm;
import com.ecommerce.entity.Product;
import com.ecommerce.enums.SEARCH_TYPE;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private EntityManager entityManager;

	@Override
	public void addDummyProduct() {
		// TODO Auto-generated method stub
		List<ProductDTO> allProduct = new ArrayList<>();
		allProduct.add(new ProductDTO("T-Shirt", 2999, 10, "Levis", "black"));
		allProduct.add(new ProductDTO("Pant", 4999, 100, "Levis", "black"));
		allProduct.add(new ProductDTO("Shoes", 10999, 110, "Adidas", "yellow"));
		allProduct.add(new ProductDTO("Bag", 2000, 210, "Adidas", "brown"));
		allProduct.add(new ProductDTO("Underwear", 299, 150, "Jockey", "red"));
		allProduct.add(new ProductDTO("Tie", 2999, 610, "Levis", "black"));
		allProduct.add(new ProductDTO("Soap", 20, 180, "Pears", "blue"));

		allProduct.forEach(product -> {
			addProduct(product);
		});

	}

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		if (Objects.isNull(productDTO)) {
			return null;
		}
		if (productDAO.countProduct(productDTO.getProdName()) == 0) {
			Product product = new Product();
			product.setProdName(productDTO.getProdName());
			product.setPrice(productDTO.getPrice());
			product.setProductQuantity(productDTO.getProductQuantity());
			product.setProductBrand(productDTO.getProductBrand());
			product.setProductColor(productDTO.getProductColor());
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

	@Override
	public List<Product> searchProduct(SearchForm searchForm) {
		List<Product> productByFilters = null;
		if (searchForm.getSearchType() != SEARCH_TYPE.CUSTOM) {

		}
		productByFilters = getProductByFilters(searchForm.getSearchParams());

		return productByFilters;
	}

	// @Scheduled(cron = "* * 1 * * * *")
	private List<Product> getProductByFilters(Map<String, Object> searchParam) {
		String sqlQuery = "FROM Product where";
		String newSqlQuery = null;
		if (searchParam.containsKey("colour")) {
			String color = searchParam.get("colour").toString();
			newSqlQuery = sqlQuery + " productColor = '" + color + "'";
		}
		if (searchParam.containsKey("lowPrice") && searchParam.containsKey("highPrice")) {
			float lowPrice = Float.parseFloat(searchParam.get("lowPrice").toString());
			float highPrice = Float.parseFloat(searchParam.get("highPrice").toString());
			if (Objects.nonNull(newSqlQuery)) {
				newSqlQuery = newSqlQuery + " AND price > " + lowPrice + " AND price < " + highPrice;
			} else {
				newSqlQuery = sqlQuery + " price > " + lowPrice + " AND price < " + highPrice;
			}
		}
		if (searchParam.containsKey("brand")) {
			String brand = searchParam.get("brand").toString();
			if (Objects.nonNull(newSqlQuery)) {
				newSqlQuery = newSqlQuery + " AND productBrand = '" + brand + "'";
			} else {
				newSqlQuery = sqlQuery + " productBrand = '" + brand + "'";
			}

		}
		if (searchParam.containsKey("lowPrice") && !searchParam.containsKey("highPrice")) {
			float lowPrice = Float.valueOf(searchParam.get("lowPrice").toString());
			if (Objects.nonNull(newSqlQuery)) {
				newSqlQuery = newSqlQuery + " AND price > " + lowPrice;
			} else {
				newSqlQuery = sqlQuery + " price = " + lowPrice;
			}
		}
		if (searchParam.containsKey("highPrice") && !searchParam.containsKey("lowPrice")) {
			float highPrice = Float.valueOf(searchParam.get("highPrice").toString());
			if (Objects.nonNull(newSqlQuery)) {
				newSqlQuery = newSqlQuery + " AND price < " + highPrice;
			} else {
				newSqlQuery = sqlQuery + " price = " + highPrice;
			}
		}

		System.out.println("Search query = " + newSqlQuery);

		Query query = entityManager.createQuery(newSqlQuery);

		List<Product> products = query.getResultList();

		return products;
	}

	@Override
	public List<Product> sortProductByPrice(int order) {
		// TODO Auto-generated method stub
		// SortProduct.order = 1;

		List<Product> allProduct = productDAO.getallProduct();
		Collections.sort(allProduct, new SortProduct(order));

		return allProduct;
	}

	@Override
	public List<Product> sortProductByQuantity() {
		// TODO Auto-generated method stub
		List<Product> allProduct = productDAO.getallProduct();

		Comparator<Product> compareByQuantity = (Product o1, Product o2) -> {
			if (o1.getProductQuantity() == o2.getProductQuantity()) {
				return 0;
			} else if (o1.getProductQuantity() > o2.getProductQuantity()) {
				return -1;
			} else
				return 1;

		};

		Collections.sort(allProduct, compareByQuantity);
		return allProduct;
	}

}
