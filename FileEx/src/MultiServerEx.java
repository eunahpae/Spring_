import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiServerEx {
	
	public static void main(String[] args) {
		MultiServerEx multiServer = new MultiServerEx();
		multiServer.start();
	}
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(8000);
			while (true) {
				System.out.println("[Ŭ���̾�Ʈ ��������]");
				socket = serverSocket.accept();
				
				// client�� �����Ҷ����� ���ο� ������ ����
				ReceiveThread receiveThread = new ReceiveThread(socket);	
				receiveThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket!=null) {
				try {
					serverSocket.close();
					System.out.println("[��������]");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("[����������ſ���]");
				}
			}
		}
	}
}

class ReceiveThread extends Thread {
	
	static List<PrintWriter> list = 
			Collections.synchronizedList(new ArrayList<PrintWriter>());
	
	Socket socket = null;
	BufferedReader in = null;
	PrintWriter out = null;
			
	public ReceiveThread (Socket socket) {
		this.socket = socket;
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			list.add(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public void run() {

		String name = "";
		try {
			// ����1ȸ�� client�̸��� ����
			name = in.readLine();
			System.out.println("[" + name + " ���������]");	
			sendAll("[" + name + "]���� �����̽��ϴ�.");
			
			while (in != null) {
				String inputMsg = in.readLine();
				if("quit".equals(inputMsg)) break;
				sendAll(name + ">>" + inputMsg);
			}
		} catch (IOException e) {
			System.out.println("[" + name + " ���Ӳ���]");
		} finally {
			sendAll("[" + name + "]���� �����̽��ϴ�");
			list.remove(out);
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[" + name + " ��������]");
	}
	
	private void sendAll (String s) {
		for (PrintWriter out: list) {
			out.println(s);
			out.flush();
		}
	}
}
