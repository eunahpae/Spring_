package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		/*
		 * System.out.println("메소드 시그니처 : " + jp.getSignature());
		 * System.out.println("메소드 시그니처 + toLongString : " + jp.getSignature().toLongString());
		 * System.out.println("메소드 시그니처 + toShortString : " + jp.getSignature().toShortString());
		 * System.out.println("클라이언트 호출 비즈니스 메소드를 포함하는 비s즈니스 객체 리턴 : " + jp.getTarget());
		 */
		
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();

		System.out.println("[사전 처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
	}
}
