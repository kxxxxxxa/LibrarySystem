package com.system.AdministratorManagement;

import com.system.MainAdministrator.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.system.MainAdministrator.InitialInterface;
import com.system.MainAdministrator.RegisterPage;
/**
 * 在管理员管理界面选着 增加管理员后，进入的界面
 * 咋能家管理员条件和注册管理员一样
 * Id:用户输入，但是不能有相同，而且只能是数字
 * 姓名:不能为空
 * 性别:必填，只能是男或女
 * 年龄:必填，只能是数字而且限制在1-100
 * 手机号码:必填，必须都是数字而且是11位
 * 登录名称:必填，有字母、数字、特殊字符组成，不能以数字开头，长度在3-8位，而且不能有重复的登录名称。
 * 登录密码:不能与登陆名称相同，而且必须是6-12位
 * 状态:用户只有三种状态，1表示正常  2表示禁用  3表示离职，默认情况下用户状态为1。
 * @author xubo
 *
 */
public class AddAdministrator {
	static String s1, s2, s4, s6, s7;
	static boolean s3;
	static Integer s5;
	static Scanner scanner3 = new Scanner(System.in);
	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner1 = new Scanner(System.in);
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------增加管理员操作---------------------------------------");
		System.out.println("                 继续操作请输入1               返回上一层请输入2                退出请输入3");
		String sss3 = scanner1.nextLine();
		if (sss3.equals("1")) {
			addAdministrator();
		}
		if (sss3.equals("2")) {
			new AdministratorManagement();
			AdministratorManagement.main(null);;
		} 
		if (sss3.equals("3")) {
			System.out.println("谢谢使用");
	}
		
	}
	public static void addAdministrator() throws IOException {
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

	public static void VerificationAccount() throws IOException {

		char[] ch2 = null;
		int count = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
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
				System.out.println("添加失败! 重新添加输入1               返回上一层输入2              退出输入3");
				sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					addAdministrator();
					break;
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
					break;
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
					break;
				}
				break;
			}
			if (s1.equals(ss2[i])) {
				System.out.println("用户名已被添加");
				System.out.println("添加失败! 重新添加输入1               返回上一层输入2              退出输入3");
				sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					addAdministrator();
					break;
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
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
					System.out.println("添加失败! 重新添加输入1              或返回上一层输入2              退出输入3");
					sss3 = scanner3.nextLine();
					if (sss3.equals("1")) {
						addAdministrator();
						break;
					} else if (sss3.equals("2")) {
						new AdministratorManagement();
						AdministratorManagement.main(null);
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
			System.out.println("添加失败! 重新添加输入1              或返回上一层输入2              退出输入3");
			sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				addAdministrator();
			} else if (sss3.equals("2")) {
				new AdministratorManagement();
				AdministratorManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			VerificationPassword();
		}

	}

	public static void VerificationPassword() throws IOException {
		int count = 0;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
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
				System.out.println(1);
				System.out.println("密码长度在6-12位");
				System.out.println("添加失败! 重新添加输入1               返回上一层输入2              退出输入3");
				sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					addAdministrator();
					break;
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
					break;
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
					break;
				}
				break;
			}
			if (s2.equals(ss2[i])) {
				System.out.println("密码域账号相同");
				System.out.println("添加失败! 重新添加输入1               返回上一层输入2              退出输入3");
				sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					addAdministrator();
					break;
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
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

	public static void VerificationTell() throws IOException {
		if (s7.length() != 11) {
			System.out.println("电话号码必须都是数字而且是11位");
			System.out.println("添加失败! 重新添加输入1              或返回上一层输入2              退出输入3");
			String sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				addAdministrator();
			} else if (sss3.equals("2")) {
				new AdministratorManagement();
				AdministratorManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			VerificationName();
		}
	}

	public static void VerificationName() throws IOException {
		if (s4.isEmpty()) {
			System.out.println("名字不能为空");
			System.out.println("添加失败! 重新添加输入1              或返回上一层输入2              退出输入3");
			String sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				addAdministrator();
			} else if (sss3.equals("2")) {
				new AdministratorManagement();
				AdministratorManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			VerificationAge();
		}
	}

	public static void VerificationAge() throws IOException {
		if (s5 > 100 || s5 < 1) {
			System.out.println("年龄只能能是数字而且在1-100");
			System.out.println("添加失败! 重新添加输入1              或返回上一层输入2              退出输入3");
			String sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				addAdministrator();
			} else if (sss3.equals("2")) {
				new AdministratorManagement();
				AdministratorManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			VerificationAddress();
		}
	}

	public static void VerificationAddress() throws IOException {
		if (s6.isEmpty()) {
			System.out.println("地址为空");
			System.out.println("添加失败! 重新添加输入1               返回上一层输入2              退出输入3");
			String sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				addAdministrator();
			} else if (sss3.equals("2")) {
				new AdministratorManagement();
				AdministratorManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			dataStorage();
		}
	}

	public static void dataStorage() throws IOException {
		Map<String, RegisterPage> mrr = new LinkedHashMap<>();
		mrr.put(new RegisterPage().getId(), new RegisterPage(s1, s2, s3, s4, s5, s6, s7));
		Collection<RegisterPage> coll = mrr.values();
		for (RegisterPage registerPage : coll) {
			System.out.println("添加成功");
			System.out.println("请牢记该账户的ID码，这将是识别该账号的身份的唯一标识：" + registerPage.getId());
			try {
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("D:\\Register.txt", true)));
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
		System.out.println("返回上一层请输入1              退出请输入2");
		String sss3 = scanner3.nextLine();
		if (sss3.equals("1")) {
			new AdministratorManagement();
			AdministratorManagement.main(null);
		} else if (sss3.equals("2")) {
			System.out.println("谢谢使用");
		}
		

	}


}
