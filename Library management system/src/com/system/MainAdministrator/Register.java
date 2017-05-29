package com.system.MainAdministrator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * 进行用户注册的页面
 * 
 */
public class Register {
	// 定义全局变量
	static Scanner scanner3 = new Scanner(System.in);
	static BufferedReader br;
	static String s1, s2, s4, s6, s7;
	static boolean s3;
	static Integer s5;
	static Map<String, RegisterPage> mrr = new LinkedHashMap<>();
	static int Allcount = 0;

	// 主函数调用子函数实现注册功能
	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------注册管理员信息---------------------------------------");
		System.out.println("\n");
		System.out.println("                         注册输入1                         返回上一层输入2");
		System.out.println("                         退出输入3                                              ");
		System.out.print("请输入：");
		Scanner scanner =new Scanner(System.in);
		String s = scanner.nextLine();
		char c=s.charAt(0);
		int i=(int)c-48;
		if (!Character.isDigit(c)||i>3) {
			System.out.println("输入有误");
			new Register().main(null);;
			
		}
		if (s.equals("1")) {
			File file = new File("D:\\Register.txt");
			if (!file.isFile()) {
				file.createNewFile();
			}
			RegisterStart();
		}
		if (s.equals("2")) {
			new InitialInterface();
			InitialInterface.main(null);
		}
		if (s.equals("3")) {
			System.out.println("谢谢使用");
		}
	}

	// 开始注册的第一个子函数 用引用VerificationAccount(); 进行条件判断
	public static void RegisterStart() throws IOException {
		char[] ch;
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		System.out.print("登录用户名：\r");
		s1 = scanner.nextLine();
		System.out.print("登录密码：\r");
		s2 = scanner.nextLine();
		System.out.print("性别(输入 true(男) false(女)：\r");
		s3 = scanner.nextBoolean();
		System.out.print("姓名：\r");
		s4 = scanner1.nextLine();
		System.out.print("年龄：\r");
		s5 = scanner1.nextInt();
		System.out.print("家庭住址：\r");
		s6 = scanner2.nextLine();
		System.out.print("电话号码：\r");
		s7 = scanner2.nextLine();
		VerificationAccount();

	}

	// 账号条件判断子函数
	// 登录名称:必填，有字母、数字、特殊字符组成，不能以数字开头，长度在3-8位，而且不能有重复的登录名称。都成功进入下一项VerificationPassword();密码条件判断
	public static void VerificationAccount() throws IOException {
		char[] ch2 = null;
		int count = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		// 从文本中读取数据 和条件进行匹配 都匹配成功进入下一项 VerificationPassword();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt"),"utf-8"));
		String ss, ss1 = "", sss3;
		String[] ss2 = null;
		while ((ss = br.readLine()) != null) {
			if (ss.indexOf("logonName=") != -1 && ss.indexOf(", pwd=") != -1) {
				String str = ss.substring(ss.indexOf("logonName=") + 10, ss.indexOf(", pwd="));
				ss1 += str + " ";
			}
		}
		ss2 = ss1.split(" ");
		char[] ch1;
		for (int i = 0; i < ss2.length; i++) {
			count4++;
			if (s1.length() > 8 || s1.length() < 3) {
				System.out.println(1);
				System.out.println("用户名长度在3-8位");
				System.out.println("注册失败! 请重新注册请输入1               返回上一层请输入2              退出请输入3");
				sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					RegisterStart();
					break;
				} else if (sss3.equals("2")) {
					new InitialInterface();
					InitialInterface.initialInterface();
					break;
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
					break;
				}
				break;
			}
			if (s1.equals(ss2[i])) {
				System.out.println("用户名已被注册");
				System.out.println("注册失败! 请重新注册请输入1               返回上一层请输入2              退出请输入3");
				sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					RegisterStart();
					break;
				} else if (sss3.equals("2")) {
					new InitialInterface();
					InitialInterface.initialInterface();
					break;
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
					break;
				}
				break;
			}
			if (!s1.equals(ss2[i])) {
			}
			ch1 = s1.toCharArray();
			for (int j = 0; j < ch1.length; j++) {
				if (Character.isDigit(ch1[0])) {
					System.out.println("登录名称首位不能使数字,登录名称用英文 数字 符号组成");
					System.out.println("注册失败! 请重新注册请输入1              或返回上一层请输入2              退出请输入3");
					sss3 = scanner3.nextLine();
					if (sss3.equals("1")) {
						RegisterStart();
						break;
					} else if (sss3.equals("2")) {
						new InitialInterface();
						InitialInterface.initialInterface();
						break;
					} else if (sss3.equals("3")) {
						System.out.println("谢谢使用");
						break;
					}
				}
				if (Character.isDigit(ch1[j])) {
					count1++;
				}
				if (Character.isLetter(ch1[j])) {
					count2++;
				}
				if (!Character.isLetterOrDigit(ch1[j])) {
					count3++;
				}
			}
		}
		if (count1 == 0 || count2 == 0 || count3 == 0) {
			System.out.println("登录名称首位不能使数字,登录名称用英文 数字 符号组成");
			System.out.println("注册失败! 请重新注册请输入1              或返回上一层请输入2              退出请输入3");
			sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				RegisterStart();
			} else if (sss3.equals("2")) {
				new InitialInterface();
				InitialInterface.initialInterface();
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			VerificationPassword();
		}

	}
    //密码条件的判断   登录密码:不能与登陆名称相同，而且必须是6-12位 成功后进入下一项 VerificationTell();电话号码的判断
	public static void VerificationPassword() throws IOException {
		int count = 0;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt"),"utf-8"));
		String ss, ss1 = "", sss3;
		String[] ss2 = null;
		while ((ss = br.readLine()) != null) {
			if (ss.indexOf("logonName=") != -1 && ss.indexOf(", pwd=") != -1) {
				String str = ss.substring(ss.indexOf("logonName=") + 10, ss.indexOf(", pwd="));
				ss1 += str + " ";
			}
		}
		ss2 = ss1.split(" ");
		for (int i = 0; i < ss2.length; i++) {
			count++;
			if (s2.length() > 12 || s2.length() < 6) {
				System.out.println("密码长度在6-12位");
				System.out.println("注册失败! 请重新注册请输入1               返回上一层请输入2              退出请输入3");
				sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					RegisterStart();
					break;
				} else if (sss3.equals("2")) {
					new InitialInterface();
					InitialInterface.initialInterface();
					break;
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
					break;
				}
				break;
			}
			if (s2.equals(ss2[i])) {
				System.out.println("密码域账号相同");
				System.out.println("注册失败! 请重新注册请输入1               返回上一层请输入2              退出请输入3");
				sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					RegisterStart();
					break;
				} else if (sss3.equals("2")) {
					new InitialInterface();
					InitialInterface.initialInterface();
					break;
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
					break;
				}
				break;
			}
		}
		System.out.println(count + "       " + ss2.length);
		if (count == ss2.length) {
			VerificationTell();
		}

	}
    //手机号码:必填，必须都是数字而且是11位，成功后进入下一项 VerificationName;姓名的判断
	public static void VerificationTell() throws IOException {
		if (s7.length() != 11) {
			System.out.println("电话号码必须都是数字而且是11位");
			System.out.println("注册失败! 请重新注册请输入1              或返回上一层请输入2              退出请输入3");
			String sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				RegisterStart();
			} else if (sss3.equals("2")) {
				new InitialInterface();
				InitialInterface.initialInterface();
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			VerificationName();
		}
	}
    //姓名:不能为空，成功后进入下一项 VerificationAge();年龄的判断
	public static void VerificationName() throws IOException {
		if (s4.isEmpty()) {
			System.out.println("名字不能为空");
			System.out.println("注册失败! 请重新注册请输入1              或返回上一层请输入2              退出请输入3");
			String sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				RegisterStart();
			} else if (sss3.equals("2")) {
				new InitialInterface();
				InitialInterface.initialInterface();
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			VerificationAge();
		}
	}
    //年龄:必填，只能是数字而且限制在1-100，成功后进入下一项 VerificationAddress()；住址的判断
	public static void VerificationAge() throws IOException {
		if (s5 > 100 || s5 < 1) {
			System.out.println("年龄只能能是数字而且在1-100");
			System.out.println("注册失败! 请重新注册请输入1              或返回上一层请输入2              退出请输入3");
			String sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				RegisterStart();
			} else if (sss3.equals("2")) {
				new InitialInterface();
				InitialInterface.initialInterface();
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			VerificationAddress();
		}
	}
    //住址:不能为空，成功后进入下一项 dataStorage();
	public static void VerificationAddress() throws IOException {
		if (s6.isEmpty()) {
			System.out.println("地址为空");
			System.out.println("注册失败! 请重新注册请输入1               返回上一层请输入2              退出请输入3");
			String sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				RegisterStart();
			} else if (sss3.equals("2")) {
				new InitialInterface();
				InitialInterface.initialInterface();
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			dataStorage();
		}
	}
    //都成功后注册成功 并把数据存储在文本中
	public static void dataStorage() throws IOException {
		mrr.put(new RegisterPage().getId(), new RegisterPage(s1, s2, s3, s4, s5, s6, s7));
		Collection<RegisterPage> coll = mrr.values();
		for (RegisterPage registerPage : coll) {
			System.out.println("注册成功");
			System.out.println("请牢记您的ID码，这将是识别您的身份的唯一标识：" + registerPage.getId());
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Register.txt", true),"utf-8"));
				bw.newLine();
				bw.write(registerPage.toString());
				bw.flush();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mrr.clear();
		System.out.println("返回上一层请输入1              退出请输入2");
		String sss3 = scanner3.nextLine();
		if (sss3.equals("1")) {
			new InitialInterface();
			InitialInterface.initialInterface();
		} else if (sss3.equals("2")) {
			System.out.println("谢谢使用");
		}
	}

}
