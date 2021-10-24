package com.example.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
//	@Before("execution(public void addAccount())") // matching any addAccount method with specify modifier and return type and no parameter
//	@Before("execution(public void com.example.aopdemo.dao.AccountDao.addAccount())") // matching specify addAccount and no parameter
//	@Before("execution(public void add*())") // matching any add method with specify modifier and return type and no parameter
//	@Before("execution(void add*())") // matching any add method with specify return type and no parameter
//	@Before("execution(* add*())") // matching any add method with any return type and no parameter
	
	// For parameters we need to give fully qualified class names
//	@Before("execution(* add*(com.example.aopdemo.Account))") // matching any add method with any return type but specific parameter
//	@Before("execution(* add*(com.example.aopdemo.Account, ..))")// matching any add method with any return type but specific first parameter and any number of parameters after that
//	@Before("execution(* add*(..))") // matching any 'add' method with any with return type with any number of parameters
//	@Before("execution(* com.example.aopdemo.dao.*.*(..))") // matching any method in specific package with any class with any return type with any number of parameters

//	@Before("forDaoPackage()") // using pointcut declaration for befor advice
//	@Before("forDaoPackageNoGetterSetter()")
//	@Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
//	public void beforeAddAccountAdvice() {
//		System.out.println("============> @Before advice on method");
//	}
	
//	@Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
//	public void forDaoPackage() {}
//
//	@Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
//	private void getter() {}
//	
//	@Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
//	private void setter() {}
//	
//	@Pointcut("forDaoPackage() && !(getter() || setter())") // combining pointcut expressions using && and || operators
//	private void forDaoPackageNoGetterSetter() {}
	
	@Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("============> @Before advice on method");
		
		// displaying method signature
		MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method sign: " + methodSign);
		
		// displaying method args
		Object[] methodArgs = joinPoint.getArgs();
		
		for (Object arg : methodArgs) {
			if (arg instanceof Account) {
				Account theAccount = (Account) arg;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			} else {
				System.out.println(arg);
			}
		}
	}
	
	@AfterReturning(
			pointcut="execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="accounts")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> accounts) {
		String method = joinPoint.getSignature().toString();
		System.out.println("\n@AfterReturning advice on method: " + method);
		System.out.println("\nreturned from the method: " + accounts);
		
		// Post-processing the returned data, 
		// it will effect the actual data that will returned to the actual caller of the target method
		if (accounts != null) {
			for (Account account : accounts) {
				account.setName(account.getName().toUpperCase());
			}
			
			System.out.println("post-processed data: " + accounts);
		}
	}
	
	@AfterThrowing(
			pointcut="execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))",
			throwing="theException")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Exception theException) {
		String method = joinPoint.getSignature().toString();
		System.out.println("\n@AfterThrowing advice on method: " + method);
		System.out.println("\nthe exception is: " + theException);
	}
	
	@After("execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toString();
		System.out.println("\n@After (finally) advice on method: " + method);
	}
	
	@Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
	public Object aroundAdviceOnGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toString();
		System.out.println("\n@Around advice on method: " + method);
		
		long beginTime = System.currentTimeMillis();
		
		Object message = null;
		
		try {
			message = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			message = "Major accident occurred!!";
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Duration: " + ((endTime - beginTime) / 1000.0) + " sec.");
		
		return message;
	}
}
