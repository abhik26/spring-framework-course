package com.example.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.service.TrafficFortuneService;

public class AroundAdviceMainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		String message = theFortuneService.getFortune();
		System.out.println("My fortune is: " + message);
		
		context.close();
	}

}
