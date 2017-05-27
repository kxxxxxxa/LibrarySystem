package com.system.MainAdministrator;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.system.AdministratorManagement.AdministratorManagement;
import com.system.BooksManagement.BooksManagement;
/**
 * 用户登录界面
 * @author xubo
 *
 */
public class SignIn {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------用户登录---------------------------------------");
		System.out.println("\n");
		System.out.println("                         登录输入1                         返回上一层输入2");
		System.out.println("                         退出输入3                                              ");
		System.out.print("请输入：");
		String s = scanner.nextLine();
		if (s.equals("1")) {
			signIn();
		}
		if (s.equals("2")) {
			new InitialInterface();
			InitialInterface.main(null);
		}
		if (s.equals("3")) {
			System.out.println("谢谢使用");
		}
	}
	public static void signIn() throws IOException{
		//定义变量
		String s;
		String ss;
		ss = initcode();
		int count = 0;
		char[] ch;
		int c = 0;
		String ss1 = null;
		String[] ss2;
		//读取文本中的文件 之后与输入数据匹配
		BufferedReader be = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
		while ((s = be.readLine()) != null) {
			if (s.indexOf("logonName=") != -1 && s.indexOf(", pwd=") != -1) {
				String str = s.substring(s.indexOf("logonName=") + 10, s.indexOf(", pwd="));
				ss1 += str + " ";
			}
			if (s.indexOf("pwd=") != -1 && s.indexOf(", gender") != -1) {
				String str = s.substring(s.indexOf("pwd=") + 4, s.indexOf(", gender"));
				ss1 += str + " ";
			}
		}
		System.out.print("登录名称：");
		String s0 = scanner.nextLine();
		System.out.print("密码：");
		String s1 = scanner.nextLine();
		System.out.println("验证码：" + ss);
		System.out.print("请输入验证码：");
		String s2 = scanner.nextLine();
		System.out.println("验证登录模式 ");
		// 与你的账号密码对比 是否匹配  匹配成功 登录 否则 重新输入  或者退出
		ss2 = ss1.split(" ");
		for (int i = 0; i < ss2.length; i++) {
			if (s0.equals(ss2[i])) {
				count++;
			}
			if (s1.equals(ss2[i])) {
				count++;
			}
		}
		if (count >= 2) {
			if (s2.equals(ss)) {
				System.out.println("登陆成功");
			}
		}
		else {
			System.out.println("登录失败! 请重新输入账号密码");
			System.out.println("忘记密码请输入3");
			System.out.println("退出请输入4");
			System.out.println("返回上一层请输入5");
			String sss3=scanner.nextLine();
			if (sss3.equals("3")) {
				new ForgotPwd();
				ForgotPwd.forgotPwd();
			}
			else if (sss3.equals("4")) {
				System.out.println("程序退出");
			}
			else if (sss3.equals("5")) {
				
			}
			else {
				signIn();
			}
			
		}

	}
	//生成6位不重复由 数字和字母组成的验证码
	public static String initcode() {
		Random random = new Random();
		int count = 0;
		char[] s;
		String d = "";
		String str = "1234567890abcdefghijklmnopqrstuvwsyz";
		while (true) {

			char a = str.charAt(random.nextInt(26));
			if (d.indexOf(a, 0) == -1) {
				d += a;
				count++;
			}
			if (count == 6) {
				break;
			}
		}
		char[] c1 = d.toCharArray();
		Arrays.sort(c1);
		return d;

	}

}
