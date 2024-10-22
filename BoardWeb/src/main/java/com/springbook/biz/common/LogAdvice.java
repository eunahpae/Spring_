/*
 * package com.springbook.biz.common;
 * 
 * import org.aopalliance.intercept.Joinpoint; import
 * org.aspectj.lang.annotation.Aspect; import
 * org.aspectj.lang.annotation.Before; import
 * org.aspectj.lang.annotation.Pointcut; import
 * org.springframework.stereotype.Service;
 * 
 * @Service
 * 
 * @Aspect // = Pointcut + Advice public class LogAdvice {
 * 
 * @Pointcut("execution(* com.springbook.biz..*Impl.*(..))") public void
 * allPointcut() {}
 * 
 * 
 * @Pointcut("execution(* com.springbook.biz..*Impl.get*(..))") public void
 * getPointcut() {}
 * 
 * 
 * @Before("allPointcut()") public void printLog(Joinpoint jp) {
 * System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작"); } }
 */