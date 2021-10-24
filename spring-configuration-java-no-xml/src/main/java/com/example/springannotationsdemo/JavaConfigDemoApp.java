package com.example.springannotationsdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SpringConfig.class);
		
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
		System.out.println("email: " + coach.getEmail());
		System.out.println("team: " + coach.getTeam());
		
		context.close();
	}

}
