package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsungtv")
public class SamsungTV implements TV {
	
	@Autowired
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("=======> SamsungTV(1) ��ü ���� ");
	}

	/*
	 * public SamsungTV(Speaker speaker) {
	 * System.out.println("=====> SamsungTV(2) ��ü ����"); this.speaker = speaker; }
	 * 
	 * public SamsungTV(Speaker speaker, int price) {
	 * System.out.println("=====> SamsungTV(3) ��ü ����"); this.speaker = speaker;
	 * this.price = price; }
	 */

	public void setSpeaker(Speaker speaker) {
		System.out.println("====>setSpeaker() ȣ��");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("====>setPrice() ȣ��");
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV --- ���� �Ҵ�. (���� : " + price + ")");

	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV --- ���� ����");

	}

	@Override
	public void volumeUp() {
		// speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// speaker = new SonySpeaker();
		speaker.volumeDown();
	}

	/*
	 * public void powerOn() { System.out.println("SamsungTV --- ���� �Ҵ�"); }
	 * 
	 * public void powerOff() { System.out.println("SamsungTV --- ���� ����"); }
	 * 
	 * public void volumeUp() { System.out.println("SamsungTV --- �Ҹ� �ø���"); }
	 * 
	 * public void volumeDown() { System.out.println("SamsungTV --- �Ҹ� ������"); }
	 */

}
