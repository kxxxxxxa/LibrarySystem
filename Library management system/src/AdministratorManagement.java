import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * 在上个页面进行选着TwoSelectThePage 选着 管理员管理后进入
 * 这个页面进行管理员的管理
 * 前提条件:只有登录成功才可以进行对管理员的操作。
 * 功能分为:增加、删除、修改、查询管理员增加
 * :参考管理员的注册功能删除:根据管理员的ID进行删除，删除时需要判断id编号是否存在，
 * 存在则删除并提示用户删除结果，否则则提示用户id编号不存在，
 * 重新输入修改:先根据用户id编号查询用户信息，然后再进行修改，修改时同样需要对输入的信息进行判断，
 * 修改成功则覆盖原先用户数据。否则进行相关信息提示。查询:分为id查询和登录名称查询
 * @author xubo
 *
 */
public class AdministratorManagement {
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
		System.out.println("---------------------------------------管理员信息管理中心---------------------------------------");
		System.out.println("\n");
		System.out.println(
				"                                   显示所有管理员信息输入-----------------1                                   ");
		System.out.println(
				"                增加管理员输入2                                              删除管理员输入3                ");
		System.out.println(
				"                修改管理员输入4                                              查询管理员输入5                ");
		System.out.print("请输入：");
		String s = scanner.nextLine();
		if (s.equals("2")) {
			new AddAdministrator();
			AddAdministrator.main(null);
		}
	}

	public static void deleteAdministrator() {

	}

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

	public static void resetPassword() throws IOException {
		System.out.println("输入新的密码：");
		String sss0 = scanner.nextLine();
		String sstr1 = null,sstr = null;
		int count01=0;
		be = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
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