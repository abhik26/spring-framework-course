package com.example.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("No orange juice for you!!!");
		}
		
		
		List<Account> accounts = new ArrayList<Account>();
		Account a1 = new Account("Abhishek", "Diamond");
		Account a2 = new Account("Tyson", "Champion");
		Account a3 = new Account("Max", "Silver");
		
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		
		return accounts;
	}
	
	public String getName() {
		System.out.println(getClass() + ": getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": addAccount");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork");
		return false;
	}
}
