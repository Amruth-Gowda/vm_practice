package com.threads.Executor;

public class MessageProcessor implements Runnable {

	private int message;

	public MessageProcessor(int i) {
		this.message = i;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " [RECIEVED MESSAGE] " + message);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " [MESSAGE PROCESSING COMPLETED] " + message);

	}
}
