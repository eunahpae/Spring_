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
			// 서버 소켓 생성, 포트 9000에서 연결 대기
			listener = new ServerSocket(9000);
			System.out.println("연결을 기다리고 있습니다.");

			// 클라이언트 연결 수락
			socket = listener.accept();
			System.out.println("정상적으로 연결 되었습니다.");

			// 클라이언트와 통신을 위한 입력 및 출력 스트림 생성
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {
				// 클라이언트로부터 메시지 한 줄 읽기
				String inputMessage = in.readLine();

				// "bye" 메시지를 받으면 연결 종료
				if (inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트가 종료를 하였습니다.");
					break;
				}

				// 클라이언트로부터 받은 메시지 출력
				System.out.println("클라이언트에서 보내온 메시지 : " + inputMessage);

				// 사용자로부터 메시지를 입력받아 클라이언트로 전송
				System.out.println("보내기 >>>");
				String outputMessage = sc.nextLine();
				out.write(outputMessage + "\n");
				out.flush(); // 버퍼를 비워 실제로 전송
			}
			
		} catch (Exception e) {
			// 예외 발생 시 연결 불가 메시지 출력
			System.out.println("연결 불가");
			
		} finally {
			try {
				// 리소스 정리: 스캐너, 소켓, 서버 소켓 닫기
				sc.close();
				socket.close();
				listener.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
