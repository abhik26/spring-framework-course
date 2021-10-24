package com.example.springannotationsdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

//	@Autowired
//	@Qualifier("fileRandomFortuneService")
	final private FortuneService fortuneService;
	
//	public TennisCoach() {
//		System.out.println(">>TennisCoach: Inside TennisCoach default constructor");
//	}
	
	// bean init method
	@PostConstruct
	public void myInitStuff() {
		System.out.println("TennisCoach: Inside my init method.");
	}
	
	// bean destroy method
	@PreDestroy
	public void myDestroyStuff() {
		System.out.println("TennisCoach: Inside my destroy method.");
	}
	
	@Autowired 
	public TennisCoach(@Qualifier("fileRandomFortuneService") FortuneService fortuneService) {
	  this.fortuneService = fortuneService;
	}
	 
	
	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService;
	 * System.out.println(">> Inside TennisCoach: setFortuneService method"); }
	 */
	
	/*
	 * @Autowired public void doMySetterStuff(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService;
	 * System.out.println(">> Inside TennisCoach: doMySetterStuff method"); }
	 */
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
