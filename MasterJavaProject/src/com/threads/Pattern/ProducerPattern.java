package com.threads.Pattern;

import java.util.concurrent.BlockingQueue;

public class ProducerPattern implements Runnable {

	BlockingQueue<Integer> questionQueue;
	private int questionNo;

	public ProducerPattern(BlockingQueue<Integer> questionQueue) {
		this.questionQueue = questionQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (this) {
					int qNo = questionNo++;
					System.out.println("got new Question: " + qNo);
					Thread.sleep(1000);
					questionQueue.put(questionNo);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			;
		}
	}

}
