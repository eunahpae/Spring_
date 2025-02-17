package com.springbook.ioc.injection;

import java.util.Iterator;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");

		/*
		 * List<String> addressList = bean.getAddressList();
		 */

		/*
		 * Set<String> addressList = bean.getAddressList(); for (String address :
		 * addressList) { System.out.println(address.toString()); }
		 */

		Map<String, String> addressList = bean.getAddressList();

		/*
		 * for (Map.Entry<String, String> entry : addressList.entrySet()) {
		 * System.out.println(entry.toString()); }
		 */

		/*
		 * Iterator<String> iter = addressList.keySet().iterator();
		 * 
		 * while (iter.hasNext()) { String key = iter.next(); String value = (String)
		 * addressList.get(key);
		 * 
		 * System.out.println(key + " : " + value); }
		 */

		for (String key : addressList.keySet()) {
			System.out.println(String.format("Ű : %s, �� : %s", key, addressList.get(key)));
		}

		factory.close();
	}
}