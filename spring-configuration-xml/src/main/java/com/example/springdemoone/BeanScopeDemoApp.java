package com.example.springdemoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("coach", Coach.class);
		
		Coach alphaCoach = context.getBean("coach", Coach.class);
		
		System.out.println("both coach points to the same object: " + (theCoach == alphaCoach));
		
		System.out.println("memory location of theCoach: " + theCoach);
		
		System.out.println("memory location of alphaCoah: " + alphaCoach);
		
		context.close();

	}

}
