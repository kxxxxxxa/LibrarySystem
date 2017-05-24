import java.io.IOException;
import java.util.Scanner;

public class InitialInterface {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------欢迎来到图书馆管理系统---------------------------------------");
		initialInterface();
	}
	public static void initialInterface() throws IOException{
		System.out.println("1   登录                                               2   注册                                               3   退出");
		System.out.print("请输入数字：");
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
			System.out.println("谢谢使用");
		}
	}

}
