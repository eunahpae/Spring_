package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		/*
		 * 객체 생성 및 사용
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();
		*/		
		
		/*
		 * TV 인터페이스를 이용한 다형성 구현
		TV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		TV tv2 = new LgTV();
		tv2.powerOn();
		tv2.powerOff();
		tv2.volumeUp();
		tv2.volumeDown();
		*/
		
		/*
		 * BeanFactory를 이용한 TV 객체 생성 및 사용
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		*/
		
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
		TV tv = (TV)factory.getBean("samsungtv");
				
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// xml에서 scope속성 값을 singleton 으로 한 경우(따로 명시하지 않아도 default), 객체를 하나만 생성
		// xml에서 scope속성 값을 prototype 으로 한 경우, 객체를 여러 개 생성
		/*
		 * TV tv1 = (TV)factory.getBean("samsung"); 
		 * TV tv2 = (TV)factory.getBean("samsung"); 
		 * TV tv3 = (TV)factory.getBean("samsung");
		 */		
		
		
		factory.close();
		
		
	}

}
