package com.threads;

public class SynchronizedThread {

	public static void main(String[] args) {
		
		NumberClass nc = new NumberClass();
		Work work = new Work("Thread-A", nc);
		work.start();
		
		Work work1 = new Work("Thread-B", nc);
		work1.start();
	}
}

class Work extends Thread {

	String name;
	NumberClass sequence = null;

	Work(String name, NumberClass sequence) {
		this.name = name;
		this.sequence = sequence;
	}

	public void run() {
		Thread.currentThread().setName(name);
		for (int i = 0; i < 100; i++) {
			try {
				sleep(1000);
				System.out.println( Thread.currentThread().getName() + " " + sequence.getNumber());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}