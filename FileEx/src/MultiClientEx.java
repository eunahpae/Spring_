import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiClientEx {

	public static void main(String[] args) {
		MultiClientEx multiClient = new MultiClientEx();
		multiClient.start();
	}

	public void start() {
		Socket socket = null;
		BufferedReader in = null;
		try {
			socket = new Socket("192.168.1.100", 8000);
			System.out.println("[������ ����Ǿ����ϴ�]");

			String name = "user" + (int) (Math.random() * 10);
			Thread sendThread = new SendThread(socket, name);
			sendThread.start();

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (in != null) {
				String inputMsg = in.readLine();
				if (("[" + name + "]���� �����̽��ϴ�").equals(inputMsg))
					break;
				System.out.println("From:" + inputMsg);
			}
		} catch (IOException e) {
			System.out.println("[���� ���Ӳ���]");
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[���� ��������]");
	}
}

class SendThread extends Thread {
		Socket socket = null;
		String name;

		Scanner scanner = new Scanner(System.in);
		
		public SendThread(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
		}

		@Override
		public void run() {
	 		try {
				// ����1ȸ�� client�� name�� ������ ����
				PrintStream out = new PrintStream(socket.getOutputStream());
				out.println(name);
				out.flush();
				
				while (true) {
					String outputMsg = scanner.nextLine();
					out.println(outputMsg);
					out.flush();
					if("quit".equals(outputMsg)) break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
