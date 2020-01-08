package com.threads.Executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutorDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		executor.execute(new MessageProcessor(1));
		executor.execute(new MessageProcessor(2));
		executor.execute(new MessageProcessor(3));
		executor.execute(new MessageProcessor(4));
		executor.execute(new MessageProcessor(5));
		executor.execute(new MessageProcessor(6));
		executor.execute(new MessageProcessor(7));
		executor.execute(new MessageProcessor(8));
		executor.execute(new MessageProcessor(9));
		executor.execute(new MessageProcessor(10));
		executor.execute(new MessageProcessor(11));

		executor.shutdown();

		while (!executor.isTerminated()) {

		}
		
		System.out.println("Message processing completed...");

	}

}
