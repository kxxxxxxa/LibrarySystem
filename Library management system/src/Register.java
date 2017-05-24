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

public class Register {
	static Scanner scanner3 = new Scanner(System.in);
	static BufferedReader br;
	static String s1, s2, s4, s6, s7;
	static boolean s3;
	static Integer s5;
	static Map<String, RegisterPage> mrr = new LinkedHashMap<>();
	static int Allcount=0;

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------注册管理员信息---------------------------------------");
		File file = new File("D:\\Register.txt");
		if (!file.isFile()) {
			file.createNewFile();
		}
		RegisterStart();
	}

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
		} else{
			VerificationPassword();
		}
			

	}
	public static void VerificationPassword() throws IOException {
		int count=0;
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
		System.out.println(count+"       "+ss2.length);
		if (count==ss2.length) {
			VerificationTell();
		}

	}
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
		}
		else {
			VerificationName();
		}
	}
	public static void VerificationName() throws IOException{
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
		}
		else{
			VerificationAge();
		}
	}
	public static void VerificationAge() throws IOException{
		if (s5>100||s5<1) {
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
		}
		else {
			VerificationAddress();
		}
	}
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
		}
		else {
			dataStorage();
		}
	}
	public static void dataStorage() throws IOException {
		mrr.put(new RegisterPage().getId(), new RegisterPage(s1, s2, s3, s4, s5, s6, s7));
		Collection<RegisterPage> coll = mrr.values();
		for (RegisterPage registerPage : coll) {
			System.out.println("注册成功");
			System.out.println("请牢记您的ID码，这将是识别您的身份的唯一标识：" + registerPage.getId());
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
			new InitialInterface();
			InitialInterface.initialInterface();
		} else if (sss3.equals("2")) {
			System.out.println("谢谢使用");
		}
	}

}
