package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.service.TrafficFortuneService;

public class AroundAdviceHandleExceptionMainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		String message = theFortuneService.getFortune(true);
		System.out.println("My fortune is: " + message);
		
		context.close();
	}

}
