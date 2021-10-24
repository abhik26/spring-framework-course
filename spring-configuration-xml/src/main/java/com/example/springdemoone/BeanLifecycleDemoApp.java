package com.example.springdemoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		Coach theCoach = context.getBean("coach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();

	}

}
