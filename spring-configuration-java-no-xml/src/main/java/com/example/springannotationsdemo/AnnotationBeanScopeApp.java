package com.example.springannotationsdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Coach coach = context.getBean("tennisCoach", Coach.class);
//		
//		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
//		
//		System.out.println("Pointing to the same object: " + (coach == alphaCoach));
//		System.out.println("Memory location of coach: " + coach);
//		System.out.println("Memory location of alphaCoach: " + alphaCoach);
		
		Coach ttCoach = context.getBean("tableTennisCoach", Coach.class);
		System.out.println(ttCoach.getDailyWorkout());
		
		
		context.close();
	}

}
