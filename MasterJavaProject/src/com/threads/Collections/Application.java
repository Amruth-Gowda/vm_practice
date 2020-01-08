package com.threads.Collections;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		InventoryManager inventoryManager = new InventoryManager();

		Thread inventoryTask = new Thread(new Runnable() {

			@Override
			public void run() {
				inventoryManager.populateProducts();
			}
		});
		
		Thread displayTask = new Thread(new Runnable() {
			
			@Override
			public void run() {
				inventoryManager.displaySoldProducts();
			}
		});
		
		inventoryTask.start();
		Thread.sleep(2000);
//		inventoryTask.join();
		displayTask.start();
	}

}
