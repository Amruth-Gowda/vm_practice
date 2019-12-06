package com.spring_03_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
//		Coach coach = context.getBean("myCoach", Coach.class);

		CricketCoach coach = context.getBean("cricketCoach", CricketCoach.class);

		System.out.println(coach.getDailyUpdate());

		System.out.println(coach.getDailyFortune());

		System.out.println(coach.getTeamName());

		System.out.println(coach.getTeamEmail());
	}
}
