import java.io.IOException;
import java.util.Scanner;

public class InitialInterface {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------��ӭ����ͼ��ݹ���ϵͳ---------------------------------------");
		initialInterface();
	}
	public static void initialInterface() throws IOException{
		System.out.println("1   ��¼                                               2   ע��                                               3   �˳�");
		System.out.print("���������֣�");
		String s=scanner.nextLine();
		if (s.equals("1")) {
			new SignIn();
			SignIn.signIn();
		}
		else if (s.equals("2")) {
			new Register();
			Register.main(null);;
			Register.RegisterStart();
		}
		else if (s.equals("3")) {
			System.out.println("ллʹ��");
		}
	}

}
