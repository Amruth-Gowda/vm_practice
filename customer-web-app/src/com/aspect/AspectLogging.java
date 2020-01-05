package com.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

	// set up logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// declare pointcut expressions
	@Pointcut("execution(* com.*.*.*(..))")
	private void beforeExec() {}

	@Pointcut("execution(* com.*.*.*(..))")
	private void afterExec() {}

	// declare before advice
	@Before("beforeExec()")
	public void beforeExecAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("executing before the method: " + methodName);
	}

//	// declare after returning advice
	@AfterReturning(pointcut="afterExec()", returning="result")
	public void afterExecAdvice(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("Executing after the method: " + methodName);
		logger.info("The obtained result: "+result);
	}
}
