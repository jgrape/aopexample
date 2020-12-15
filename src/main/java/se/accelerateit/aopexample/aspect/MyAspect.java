package se.accelerateit.aopexample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MyAspect {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before(value = "execution(* se.accelerateit.aopexample.business.BusinessService.calculateSomething(..))")
  public void before(JoinPoint joinPoint) {
    logger.info("MyAspect.before: before execution of {}", joinPoint);
  }


  @After(value = "execution(* se.accelerateit.aopexample.business.*.*(..))")
  public void after(JoinPoint joinPoint) {
    logger.info("MyAspect.after: after execution of {}", joinPoint);
  }


  @AfterReturning(value = "execution(* se.accelerateit.aopexample.business.BusinessService.*(..))",
    returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result) {
    logger.info("MyAspect.afterReturning: {} returned with value {}", joinPoint, result);
  }


  @Around("@annotation(SuperSpecial)")
  public Object superSpecial(ProceedingJoinPoint joinPoint) throws Throwable {
    logger.info("MyAspect.superSpecial BEGIN: {}", joinPoint);
    Object value = joinPoint.proceed();
    logger.info("MyAspect.superSpecial END: {}", joinPoint);
    return value;
  }

}