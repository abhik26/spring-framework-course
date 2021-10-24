package com.example.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Except heavy traffic this morning!!";
	}

	public String getFortune(boolean b) {
		if (b) {
			throw new RuntimeException("Maintenance in progress. Highway Closed!");
		}
		return getFortune();
	}
}
