package com.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//Aspect configuration class for configuring Advices and weaving them in runtime

@Aspect
@Component
public class AspectConfig {


	//Advice to log the start and end of all DAO methods and the execution time;
	@Around("com.demo.aspect.PointCutConfig.adviceAll()")
	public Object spyAll(ProceedingJoinPoint joint) throws Throwable
	{
		System.out.println();
		System.out.println("---------------------log: About to run :"+joint.getSignature().toShortString()+"---------------------");
		System.out.println();
		long begin=System.currentTimeMillis();
		Object result=null;
		try
		{
		result=joint.proceed();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("---------------------log: Exception :"+e.getMessage()+"---------------------");
			throw e;
		}
		long end=System.currentTimeMillis();
		long duration=end-begin;
		System.out.println();
		System.out.println("---------------------log: Execution ended :"+joint.getSignature().toShortString()+"---------------------");
		System.out.println();
		System.out.println("Time taken for execution:"+duration/1000+" seconds");
		
		

		
		return result;
	}
	
	
}
