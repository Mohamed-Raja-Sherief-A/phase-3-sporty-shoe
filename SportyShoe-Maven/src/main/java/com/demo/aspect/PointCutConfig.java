package com.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//Pointcut central class to store all pointcut expressions
@Aspect
public class PointCutConfig {

	@Pointcut("execution(* com.demo.DAO.*.add*(..))")
	public void adviceAdd() {}
	
	@Pointcut("execution(* com.demo.DAO.*.get*(..))")
	public void adviceGet() {}
	
	@Pointcut("execution(* com.demo.DAO.*.*(..))")
	public void adviceAll() {}
}
