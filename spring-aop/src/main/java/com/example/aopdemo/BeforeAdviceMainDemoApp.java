package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDao;
import com.example.aopdemo.dao.MembershipDAO;

public class BeforeAdviceMainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDao", MembershipDAO.class);
		
		Account myAccount = new Account();
		myAccount.setName("David Jones");
		myAccount.setLevel("Platinum");
		
		accountDao.addAccount(myAccount, true);
		accountDao.doWork();
		
		// calling accountDao getter/setter methods
		accountDao.setName("foobar_name");
		accountDao.setServiceCode("foobar_service_code");
		
		accountDao.getName();
		accountDao.getServiceCode();
		
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		
		context.close();
	}

}
