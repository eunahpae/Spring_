import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

    public static void main(String[] args) {

        BufferedReader in = null;
        BufferedWriter out = null;

        Socket socket = null;
        Scanner sc = new Scanner(System.in);
        
        try {
            // ������ IP�� ��Ʈ�� ����Ͽ� ���� ����, ������ ���� �õ�
            socket = new Socket("192.168.1.114", 9000);
            
            // �������� ����� ���� �Է� �� ��� ��Ʈ�� ����
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            while (true) {
                // ����ڷκ��� �޽��� �Է¹ޱ�
                String outputMessage = sc.nextLine();
                
                // "bye"�� �Է��ϸ� ������ ���� �� ���� ����
                if (outputMessage.equalsIgnoreCase("bye")) {
                    out.write(outputMessage + "\n");
                    out.flush();
                    break;
                }

                // ������ �޽��� ����
                out.write(outputMessage + "\n");
                out.flush();
                
                // �����κ��� �޽��� �б�
                String inputMessage = in.readLine();
                System.out.println("���� : " + inputMessage);
            }
            
        } catch (Exception e) {
            // ���� �߻� �� ���� Ʈ���̽� ���
            e.printStackTrace();
            
        } finally {
            try {
                // ���ҽ� ����: ��ĳ�ʿ� ���� �ݱ�
                sc.close();
                socket.close();
                
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
