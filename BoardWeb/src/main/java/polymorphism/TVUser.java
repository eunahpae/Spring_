package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		/*
		 * ��ü ���� �� ���
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
		 * TV �������̽��� �̿��� ������ ����
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
		 * BeanFactory�� �̿��� TV ��ü ���� �� ���
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		*/
		
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup)�Ѵ�.
		TV tv = (TV)factory.getBean("samsung");
				
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		// xml���� scope�Ӽ� ���� singleton ���� �� ���(���� �������� �ʾƵ� default), ��ü�� �ϳ��� ����
		// xml���� scope�Ӽ� ���� prototype ���� �� ���, ��ü�� ���� �� ����
		TV tv1 = (TV)factory.getBean("samsung");
		TV tv2 = (TV)factory.getBean("samsung");
		TV tv3 = (TV)factory.getBean("samsung");
		
		
		
		factory.close();
		
		
	}

}