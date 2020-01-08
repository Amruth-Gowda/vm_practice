package com.threads.Pattern;

import java.util.concurrent.BlockingQueue;

public class ConsumerPattern implements Runnable {
	BlockingQueue<Integer> questionQueue;
	private int questionNo;

	public ConsumerPattern(BlockingQueue<Integer> questionQueue) {
		this.questionQueue = questionQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				System.out.println("Question anwserd: "+questionQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
