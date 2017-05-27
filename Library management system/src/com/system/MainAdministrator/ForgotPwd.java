package com.system.MainAdministrator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 忘记密码后的操作
 * @author xubo
 *
 */
public class ForgotPwd {
	//定义全局变量
	static Scanner scanner = new Scanner(System.in);
	static String s2 = null, ss;
	static int count = 0;
	static String ss1 = null;
	static String[] ss2;
	static String s0;
	static BufferedReader br, be;
	static Scanner scanner1 = new Scanner(System.in);
	static List<String> list = new ArrayList<>();
	static String s, s1, str = null, str1 = null, str2 = null;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------忘记密码---------------------------------------");
		System.out.println("\n");
		System.out.println("                         找回密码输入1                         返回上一层输入2");
		System.out.println("                         退出输入3                                              ");
		System.out.print("请输入：");
		Scanner scanner =new Scanner(System.in);
		String s = scanner.nextLine();
		if (s.equals("1")) {
			forgotPwd();
		}
		if (s.equals("2")) {
			new InitialInterface();
			InitialInterface.main(null);
		}
		if (s.equals("3")) {
			System.out.println("谢谢使用");
		}
	}
    //forgotPwd();功能是 通过 账号+ID码与文本中的数据进行比对 都通过进行密码的找回 并显示原密码
	public static void forgotPwd() throws IOException {
		System.out.print(" 登录名称：");
		s0 = scanner.nextLine();
		System.out.print("用户ID码：");
		String s1 = scanner.nextLine();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("id=") != -1 && s.indexOf(",logonName=") != -1) {
				str = s.substring(s.indexOf("id=") + 3, s.indexOf(",logonName="));
				if (s.indexOf("logonName=") != -1 && s.indexOf(", pwd=") != -1) {
					str1 = s.substring(s.indexOf("logonName=") + 10, s.indexOf(", pwd="));
				}
			}
			if (s0.equals(str1) && s1.equals(str)) {
				str2 = s;
				count++;
			} else {
				list.add(s);
			}
		}
		if (count == 1) {
			System.out.println("验证成功");
			System.out.println("原密码为：" + str2.substring(str2.indexOf("pwd=") + 4, str2.indexOf(", gender")));
			System.out.println("重新设置输入1               返回上一层请输入2              退出请输入3");
			String sss3 = scanner1.nextLine();
			if (sss3.equals("1")) {
				resetPassword();
			} else if (sss3.equals("2")) {
				new SignIn();
				SignIn.signIn();
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			System.out.println("验证错误： 账号与ID码不匹配");
			System.out.println("重新输入1               返回上一层请输入2              退出请输入3");
			String sss3 = scanner1.nextLine();
			if (sss3.equals("1")) {
				forgotPwd();
			} else if (sss3.equals("2")) {
				new SignIn();
				SignIn.signIn();
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		}
	}
    //账号+ID码的验证通过后，推荐用户进行修改密码的操作 修改的密码不能与原密码相同 如果相同提示用户重设密码
	public static void resetPassword() throws IOException {
		System.out.println("输入新的密码：");
		String sss0 = scanner.nextLine();
		String sstr1 = null,sstr = null;
		int count01=0;
		be = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt"),"utf-8"));
		while ((s1 = be.readLine()) != null) {
			if (s1.indexOf("logonName=") != -1 && s1.indexOf(", pwd=") != -1) {
				sstr1 = s1.substring(s1.indexOf("logonName=") + 10, s1.indexOf(", pwd="));
				if (s1.indexOf("pwd=") != -1 && s1.indexOf(", gender") != -1) {
					sstr = s1.substring(s1.indexOf("pwd=") + 4, s1.indexOf(", gender"));
				}
			}
			if (s0.equals(sstr1)&&sss0.equals(sstr)) {
				count01++;
				break;
			}

		}
		if (sss0.length() > 12 || sss0.length() < 6||count01==1) {
			System.out.println("密码长度在6-12位,且不能与原密码相同");
			System.out.println("设置失败! 请重新请输入1               返回上一层请输入2              退出请输入3");
			sss0 = scanner.nextLine();
			if (sss0.equals("1")) {
				resetPassword();
			} else if (sss0.equals("2")) {
				new SignIn();
				SignIn.signIn();
			} else if (sss0.equals("3")) {
				System.out.println("谢谢使用");
			}
		}
		else{
		str2 = str2.substring(0, (str2.indexOf("pwd=") + 4)) + sss0+ str2.substring(str2.indexOf(", gender"), str2.indexOf("正常") + 3);
		list.add(str2);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Register.txt")));
		for (String string : list) {
			bw.write(string);
			bw.flush();
		}
		System.out.println("密码修改成功");
		System.out.println("返回上一层请输入1              退出请输入2");
		String sss3 = scanner1.nextLine();
		if (sss3.equals("1")) {
			new SignIn();
			SignIn.signIn();
		} else if (sss3.equals("2")) {
			System.out.println("谢谢使用");
		}
	}
	}

}
