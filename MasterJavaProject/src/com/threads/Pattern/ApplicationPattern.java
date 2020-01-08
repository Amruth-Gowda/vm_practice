package com.threads.Pattern;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ApplicationPattern {

	public static void main(String[] args) {
		BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(6);
		
		Thread read = new Thread(new ProducerPattern(questionQueue));
		Thread write = new Thread(new ConsumerPattern(questionQueue));
		
		read.start();
		write.start();
	}

}
