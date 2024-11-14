package co.pragra.learning.resttemplatedemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class PersonalAspect {
    @Before("execution(String co.pragra.learning.resttemplatedemo.controller.AopDemoController.getStatus())")
    public void logBefore(JoinPoint joinPoint) {
        log.info("I am logBefore Advice in " + joinPoint.getSignature());
    }

    @After("execution(String co.pragra.learning.resttemplatedemo.controller.AopDemoController.getStatus())")
    public void logAfter(JoinPoint joinPoint) {
        log.info("I am logAfter Advice in " + joinPoint.getSignature());
    }

    @Around("execution(String co.pragra.learning.resttemplatedemo.controller.AopDemoController.getStatus())")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("I am logAround Before Advice in " + joinPoint.getSignature());
        joinPoint.proceed();
        log.info("I am logAround After Advice in " + joinPoint.getSignature());
    }

}
