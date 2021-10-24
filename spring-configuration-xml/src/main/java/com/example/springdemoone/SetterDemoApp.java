package com.example.springdemoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("coach", Coach.class);
		
		Coach coach1 = context.getBean("coach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
//		System.out.println(coach.getEmailAddress());
//		
//		System.out.println(coach.getTeam());
		
		context.close();
	}

}
