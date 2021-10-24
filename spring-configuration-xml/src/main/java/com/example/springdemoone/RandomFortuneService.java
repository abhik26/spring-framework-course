package com.example.springdemoone;

import java.util.ArrayList;
import java.util.List;

public class RandomFortuneService implements FortuneService {
	
	private List<String> randomFortunes;
	
	public RandomFortuneService() {
		this.randomFortunes = new ArrayList<String>();
		this.randomFortunes.add("Today is your victory day!");
		this.randomFortunes.add("Today is your losing day!");
		this.randomFortunes.add("Today is your instrospection day!");
	}

	@Override
	public String getFortune() {
		int randomNum = (int) (Math.random() * this.randomFortunes.size());
		return this.randomFortunes.get(randomNum);
	}

}
