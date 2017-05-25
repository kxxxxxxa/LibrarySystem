import java.util.Scanner;
/*
 * 登录成功后进入的管理员选着界面
 */
public class TwoSelectThePage {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("---------------------------------------管理选着页面---------------------------------------");
		System.out.println("\n");
		System.out.println("                         管理员管理输入1                         图书管理输入2"        );
		String s=scanner.nextLine();
	}

}

