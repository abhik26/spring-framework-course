package com.example.springdemoone;

public class BaseballCoach implements Coach {
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void doMyStartupStuff() {
		System.out.println("BaseballCoach: inside method - doMyStartupStuff");
	}
	
	public void doMyDestroyStuff() {
		System.out.println("BaseballCoach: inside method - doMyDestroyStuff");
	}
}
