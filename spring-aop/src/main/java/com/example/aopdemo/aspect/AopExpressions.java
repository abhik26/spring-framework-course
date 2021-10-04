package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	// Pointcut declarations
	@Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}

	@Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())") // combining pointcut expressions using && and || operators
	public void forDaoPackageNoGetterSetter() {}
}
