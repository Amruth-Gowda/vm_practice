package com.spring_02_dependancy_injection;

public class CricketCoach implements Coach {

	private HappyFortuneService fortuneService;
	private String teamName;
	private String teamEmail;

	public CricketCoach() {
		System.out.println("Cricket coach: inside the default constructor ");
	}

	public CricketCoach(HappyFortuneService fortuneService) {
		System.out.println("Cricket coach: inside the parameterized constructor ");
		this.fortuneService = fortuneService;
	}

	public void setFortuneService(HappyFortuneService fortuneService) {
		System.out.println("cricket coach: inside setter method");
		this.fortuneService = fortuneService;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamEmail() {
		return teamEmail;
	}

	public void setTeamEmail(String teamEmail) {
		this.teamEmail = teamEmail;
	}

	public String getDailyUpdate() {
		return "Cricket coach: practice bowling for 45 mins";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
