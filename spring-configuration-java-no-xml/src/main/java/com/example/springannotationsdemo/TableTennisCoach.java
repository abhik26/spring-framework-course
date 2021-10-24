package com.example.springannotationsdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TableTennisCoach implements Coach, DisposableBean {

	@Override
	public String getDailyWorkout() {
		return "Practice top-spin for 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		return "Today is your winning day!";
	}
	
	@PostConstruct
	public void myStartupStuff() {
		System.out.println("TableTennisCoach: inside myStartupStuff method");
	}

	@Override
	public void destroy() {
		System.out.println("TableTennisCoach: Inside destroy method for prototype scoped bean");
	}
	
}
