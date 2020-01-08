package com.threads;

public class NumberClass {

	int value = 0;
	
	//sychronized key word in thread is used to manage the resource handling
	//by different sources in a synchronized fashion
	public synchronized int getNumber() {
		value = value + 1;
		return value;
	}
}
