package com.example.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDao;

public class AfterAdvice_Returning_Throwing_Finally_MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		try {
			List<Account> accounts = accountDao.findAccounts(true);
		} catch (Exception e) {
			System.out.println(new AfterAdvice_Returning_Throwing_Finally_MainDemoApp().getClass());
		}
		
		context.close();
	}

}
