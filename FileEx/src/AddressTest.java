import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressTest {

	public static void main(String[] args) throws UnknownHostException {

		InetAddress ad = InetAddress.getLocalHost();
		System.out.println("컴퓨터 이름은 : " + ad.getHostName());
		System.out.println("컴퓨터 IP 주소는 : " + ad.getHostAddress());

		System.out.println("============================");
		InetAddress bc = InetAddress.getByName("www.google.com");
		System.out.println("구글 주소는 : " + bc.getHostAddress());

		System.out.println("============================");
		InetAddress all[] = InetAddress.getAllByName("www.naver.com");
		for(int i=0; i<all.length; i++) {
			System.out.println(all[i]);
		}
	}
}
