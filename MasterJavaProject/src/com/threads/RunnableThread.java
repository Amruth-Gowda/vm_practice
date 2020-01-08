package com.threads;

public class RunnableThread {

	public static void main(String[] args) {
		
//		TaskRun taskRun = new TaskRun();
//		Thread task = new Thread(taskRun);
		
		Thread task = new Thread(new TaskRun());
		task.start();
		
		Thread task2 = new Thread(new TaskRun());
		task2.start();

	}
}

class TaskRun implements Runnable {
	public void run() {
		for (int i = 0; i <= 50; i++) {
			System.out.println(Thread.currentThread().getName()+" number: " + i);
		}
	}
}