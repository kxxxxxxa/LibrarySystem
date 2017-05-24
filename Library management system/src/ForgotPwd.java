import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ForgotPwd {
	static Scanner scanner = new Scanner(System.in);
	static String s,s2 = null,ss;
	static int count=0;
	static String ss1=null;
	static String[] ss2;
	static BufferedReader be;
	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------忘记密码---------------------------------------");
		forgotPwd();
	}
	public static void forgotPwd() throws IOException{
		be = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
		while ((s = be.readLine()) != null) {
			if (s.indexOf("logonName=") != -1 && s.indexOf(", pwd=") != -1) {
				String str = s.substring(s.indexOf("logonName=") + 10, s.indexOf(", pwd="));
				ss1 += str + " ";
			}
			if (s.indexOf("id=") != -1 && s.indexOf(",logonName=") != -1) {
				String str = s.substring(s.indexOf("id=") + 3, s.indexOf(",logonName="));
				ss1 += str + " ";
			}
		}
		System.out.print(" 登录名称：");
		String s0=scanner.nextLine();
		System.out.println("用户ID码：");
		String s1=scanner.nextLine();
		ss2 = ss1.split(" ");
		for (int i = 0; i < ss2.length; i++) {
			if (s0.equals(ss2[i])) {
				count++;
			}
			if (s1.equals(ss2[i])) {
				count++;
			}
		}
		System.out.println(count);
		if (count == 2) {
			System.out.println("验证成功");
			resetPassword();
		}
	}
	public static void resetPassword() throws IOException{
		System.out.println("输入新的密码：");
		String sss3 = null;
		String[] sss2;
		String sss0=scanner.nextLine();
		be = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
		while ((s = be.readLine()) != null) {
			if (s.indexOf("pwd=") != -1 && s.indexOf(", gender") != -1) {
				String str = s.substring(s.indexOf("pwd=") + 4, s.indexOf(", gender"));
				sss3 += str + " ";
			}
		}
		sss2=sss3.split(" ");
		for (int i = 0; i < sss2.length; i++) {
			if (sss0.equals(sss2[i])) {
				System.out.println("与原密码相同请从新输入");
				resetPassword();
			}

		}
		
	}


}
