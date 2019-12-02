package com.spring_01_inversion_control;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// configure the application context file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// load the beans
		Coach coach = context.getBean("myCoach", Coach.class);

		// print out the task
		System.out.println(coach.getDailyUpdate());

		// close the context
		context.close();
	}
}
