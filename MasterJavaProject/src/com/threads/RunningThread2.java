package com.threads;

public class RunningThread2 {

	public static void main(String... args) {

		Thread task = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i <= 50; i++) {
					System.out.println(Thread.currentThread().getName() + " number: " + i);
				}
			}
		});
		
		Thread task1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i <= 50; i++) {
					System.out.println(Thread.currentThread().getName() + " number: " + i);
				}
			}
		});

		task.start();
		task1.start();
	}
}
