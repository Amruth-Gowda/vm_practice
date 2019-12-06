package com.spring_02_dependancy_injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Coach coach = context.getBean("myCoach", Coach.class);

		CricketCoach coach = context.getBean("myCoach", CricketCoach.class);

		System.out.println(coach.getDailyUpdate());

		System.out.println(coach.getDailyFortune());

		System.out.println(coach.getTeamName());

		System.out.println(coach.getTeamEmail());
	}
}
