package com.threads;

public class BasicThread {

	public static void main(String[] args) {
		
		Task task = new Task();
		task.start();
		
		Task task2 = new Task();
		task2.start();
	}
}

class Task extends Thread {

	public String name;

	Task(){
	}
	
	Task(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName()+" number: " + i);
		}
	}
	
}
