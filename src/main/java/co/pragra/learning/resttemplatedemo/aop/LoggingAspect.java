//package co.pragra.learning.resttemplatedemo.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Slf4j
//@Component
//public class LoggingAspect {
//    @AfterReturning("pt1()|| pt2()")
//    public void logEverything(JoinPoint joinPoint) {
//        log.info("This is method: " + joinPoint.getSignature().getName());
//        log.info("I am an advice in LoggingAspect");
//    }
//
//    @Pointcut("execution(* co.pragra.learning.resttemplatedemo.controller.*.* (..))")
//    public void pt1(){
//
//    }
//
//    @Pointcut("within(co.pragra.learning.resttemplatedemo.controller.*.*)")
//    public void pt2(){
//
//    }
//}
