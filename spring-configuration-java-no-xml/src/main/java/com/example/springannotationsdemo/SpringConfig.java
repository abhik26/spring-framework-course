package com.example.springannotationsdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.example.springannotationsdemo")
@PropertySource("classpath:sports.properties")
public class SpringConfig {
	
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		SwimCoach coach = new SwimCoach(happyFortuneService());
		return coach;
	}

}
