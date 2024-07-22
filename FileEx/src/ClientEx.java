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
            // 서버의 IP와 포트를 사용하여 소켓 생성, 서버에 연결 시도
            socket = new Socket("192.168.1.114", 9000);
            
            // 서버와의 통신을 위한 입력 및 출력 스트림 생성
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            while (true) {
                // 사용자로부터 메시지 입력받기
                String outputMessage = sc.nextLine();
                
                // "bye"를 입력하면 서버에 전송 후 연결 종료
                if (outputMessage.equalsIgnoreCase("bye")) {
                    out.write(outputMessage + "\n");
                    out.flush();
                    break;
                }

                // 서버로 메시지 전송
                out.write(outputMessage + "\n");
                out.flush();
                
                // 서버로부터 메시지 읽기
                String inputMessage = in.readLine();
                System.out.println("서버 : " + inputMessage);
            }
            
        } catch (Exception e) {
            // 예외 발생 시 스택 트레이스 출력
            e.printStackTrace();
            
        } finally {
            try {
                // 리소스 정리: 스캐너와 소켓 닫기
                sc.close();
                socket.close();
                
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
