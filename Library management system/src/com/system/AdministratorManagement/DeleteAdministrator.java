package com.system.AdministratorManagement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteAdministrator {
	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	static String s2 = null, ss;
	static int count = 0;
	static String ss1 = null;
	static String[] ss2;
	static String s0;
	static BufferedReader br, be;
	static Scanner scanner1 = new Scanner(System.in);
	static String s, s1, str = null, str1 = null, str2 = null;
	static List<String> list = new ArrayList<>();
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------删除管理员操作---------------------------------------");
		System.out.println("                 删除请输入1               返回上一层请输入2                退出请输入3");
		String sss3 = scanner1.nextLine();
		if (sss3.equals("1")) {
			deleteAdministrator();
		}
		if (sss3.equals("2")) {
			new AdministratorManagement();
			AdministratorManagement.main(null);;
		} 
		if (sss3.equals("3")) {
			System.out.println("谢谢使用");
	}

	}

	public static void deleteAdministrator() throws IOException {
		System.out.print("输入删除用户ID码：");
		String s1 = scanner.nextLine();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt"),"utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("id=") != -1 && s.indexOf(",logonName=") != -1) {
				str = s.substring(s.indexOf("id=") + 3, s.indexOf(",logonName="));
			}
			if (s1.equals(str)) {
				count++;
			} else {
				list.add(s);
			}
		} 
//		System.out.println(list.size());
		if (count !=0) {
			count=0;
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Register.txt"),"utf-8"));
			for (String string : list) {
				bw.newLine();
				bw.write(string);
				bw.flush();
			}
			list .clear();
			System.out.println("输入有效,删除成功");
			System.out.println("继续删除输入1               返回上一层请输入2              退出请输入3");
			String sss3 = scanner1.nextLine();
			if (sss3.equals("1")) {
				deleteAdministrator();
			} else if (sss3.equals("2")) {
				new AdministratorManagement();
				AdministratorManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			count=0;
			System.out.println("验证错误：ID码错误");
			System.out.println("重新输入输入1               返回上一层请输入2              退出请输入3");
			String sss3 = scanner1.nextLine();
			if (sss3.equals("1")) {
				deleteAdministrator();
			} else if (sss3.equals("2")) {
				new AdministratorManagement();
				AdministratorManagement.main(null);;
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		}

	}

}
