package com.threads.Collections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager{
	List<Product> soldProductList = new CopyOnWriteArrayList<>();
//	List<Product> purhcasedProductList = new ArrayList<>();

	public void populateProducts() {
		for (int i = 1; i <= 50; i++) {
			Product product = new Product(i, i + "th product");
			soldProductList.add(product);
			System.out.println("Adding: " + product);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void displaySoldProducts() {
		for (Product product : soldProductList) {
			System.out.println("Printing the sold: " + product);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
