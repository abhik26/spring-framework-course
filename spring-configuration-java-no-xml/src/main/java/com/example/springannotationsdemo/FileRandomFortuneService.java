package com.example.springannotationsdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileRandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		String theFortune = "Oops! Better luck next time.";
		FileReader fileReader = null;
		BufferedReader br = null;
		
		try {
			List<String> fortunes = new ArrayList<String>();
			fileReader = 
					new FileReader("D:\\Documents\\eclipse-workspace\\spring-annotations-demo\\src\\fortunes.txt");
			br = new BufferedReader(fileReader);
			String line;
			
			while ((line = br.readLine()) != null) {
				fortunes.add(line);
			}
			
			Random random = new Random();
			int index = random.nextInt(fortunes.size());
			theFortune = fortunes.get(index);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
				
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {}
		}
		
		return theFortune;
	}

	@PostConstruct
	public void startupStuff() {
		System.out.println("FileRandomFortuneService: inside startupStuff method");
		FileReader fileReader = null;
		BufferedReader br = null;
		
		try {
			List<String> fortunes = new ArrayList<String>();
			fileReader = 
					new FileReader("D:\\Documents\\eclipse-workspace\\spring-annotations-demo\\src\\fortunes.txt");
			br = new BufferedReader(fileReader);
			String line;
			System.out.println("Reading all the fortunes from the file");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
				
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {}
		}
	}
}
