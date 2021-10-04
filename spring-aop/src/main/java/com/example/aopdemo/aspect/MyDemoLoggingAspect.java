package com.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	// Pointcut declarations
	
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
	
	@Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("============> @Before advice on method");
		
		// displaying method signature
		MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method sign: " + methodSign);
	}
}
