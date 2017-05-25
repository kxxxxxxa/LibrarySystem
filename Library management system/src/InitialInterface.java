import java.io.IOException;
import java.util.Scanner;
/**
 * 初始化界面
 * 用户进行选着
 * @author xubo
 *
 */
public class InitialInterface {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------初始化界面---------------------------------------");
		initialInterface();
	}
	public static void initialInterface() throws IOException{
		System.out.println("                   登录输入1                   注册输入2                   退出输入3");
		System.out.print("请您输入：");
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
