package com.ecommerce.comparator;
import java.util.Comparator;

import com.ecommerce.entity.Product;

public class SortProduct implements Comparator<Product> {
	
	public  int order;
	
	public SortProduct(int order) {
		this.order = order;
	}

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		if(order == 1) {
		if(o1.getPrice() == o2.getPrice()) {
			return 0;
		}else if(o1.getPrice() > o2.getPrice()) {
			return -1;
		}else
			return 1;
		}else {
			if(o1.getPrice() == o2.getPrice()) {
				return 0;
			}else if(o1.getPrice() > o2.getPrice()) {
				return 1;
			}else
				return -1;
			
		}
	}

	
		
}
