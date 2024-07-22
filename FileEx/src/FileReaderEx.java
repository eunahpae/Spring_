import java.io.FileReader; // ������ �б� ���� FileReader Ŭ������ ������

public class FileReaderEx { // Ŭ���� ����

    public static void main(String[] args) { // ���α׷��� ���۵Ǵ� ���� �Լ�

        FileReader fin = null; // ������ ���� �غ� �ϴ� ���� fin�� ����.
        
        try {
            fin = new FileReader("c:\\windows\\system.ini"); // Ư�� ������ �о��
            int c; // ���Ͽ��� �ϳ��� ���ڸ� �������� ���� ���� ����.
            while ((c = fin.read()) != -1) { // ������ ������ ���ڸ� �ϳ��� �о��.
                System.out.print((char)c); // ���� ���ڸ� ���ڷ� �ٲ㼭 ������.
            }
            fin.close(); // ���� �бⰡ ������ �ݾ���.
        } catch (Exception e) { 
            System.out.println("������ ���� �� �����ϴ�.");
        }
    }
}
