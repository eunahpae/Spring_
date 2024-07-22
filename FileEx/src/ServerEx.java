import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {

	public static void main(String[] args) {

		BufferedReader in = null;
		BufferedWriter out = null;

		ServerSocket listener = null;
		Socket socket = null;

		Scanner sc = new Scanner(System.in);
		try {
			// ���� ���� ����, ��Ʈ 9000���� ���� ���
			listener = new ServerSocket(9000);
			System.out.println("������ ��ٸ��� �ֽ��ϴ�.");

			// Ŭ���̾�Ʈ ���� ����
			socket = listener.accept();
			System.out.println("���������� ���� �Ǿ����ϴ�.");

			// Ŭ���̾�Ʈ�� ����� ���� �Է� �� ��� ��Ʈ�� ����
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {
				// Ŭ���̾�Ʈ�κ��� �޽��� �� �� �б�
				String inputMessage = in.readLine();

				// "bye" �޽����� ������ ���� ����
				if (inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Ŭ���̾�Ʈ�� ���Ḧ �Ͽ����ϴ�.");
					break;
				}

				// Ŭ���̾�Ʈ�κ��� ���� �޽��� ���
				System.out.println("Ŭ���̾�Ʈ���� ������ �޽��� : " + inputMessage);

				// ����ڷκ��� �޽����� �Է¹޾� Ŭ���̾�Ʈ�� ����
				System.out.println("������ >>>");
				String outputMessage = sc.nextLine();
				out.write(outputMessage + "\n");
				out.flush(); // ���۸� ��� ������ ����
			}
			
		} catch (Exception e) {
			// ���� �߻� �� ���� �Ұ� �޽��� ���
			System.out.println("���� �Ұ�");
			
		} finally {
			try {
				// ���ҽ� ����: ��ĳ��, ����, ���� ���� �ݱ�
				sc.close();
				socket.close();
				listener.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
