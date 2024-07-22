import java.io.FileReader; // 파일을 읽기 위한 FileReader 클래스를 가져옴

public class FileReaderEx { // 클래스 시작

    public static void main(String[] args) { // 프로그램이 시작되는 메인 함수

        FileReader fin = null; // 파일을 읽을 준비를 하는 변수 fin을 생성.
        
        try {
            fin = new FileReader("c:\\windows\\system.ini"); // 특정 파일을 읽어옴
            int c; // 파일에서 하나씩 글자를 가져오기 위한 변수 생성.
            while ((c = fin.read()) != -1) { // 파일의 끝까지 글자를 하나씩 읽어옴.
                System.out.print((char)c); // 읽은 숫자를 글자로 바꿔서 보여줌.
            }
            fin.close(); // 파일 읽기가 끝나면 닫아줌.
        } catch (Exception e) { 
            System.out.println("파일을 읽을 수 없습니다.");
        }
    }
}
