package com.example.springannotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice pull shot";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
}
