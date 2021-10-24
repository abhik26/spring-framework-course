package com.example.springdemoone;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice hook shot today.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
