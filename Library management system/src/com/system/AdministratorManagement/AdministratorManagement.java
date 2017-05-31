package com.system.AdministratorManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.system.MainAdministrator.SignIn;
import com.system.MainAdministrator.TwoSelectThePage;

/**
 * 在上个页面进行选着TwoSelectThePage 选着 管理员管理后进入 这个页面进行管理员的管理 前提条件:只有登录成功才可以进行对管理员的操作。
 * 功能分为:增加、删除、修改、查询管理员增加 :参考管理员的注册功能删除:根据管理员的ID进行删除，删除时需要判断id编号是否存在，
 * 存在则删除并提示用户删除结果，否则则提示用户id编号不存在，
 * 重新输入修改:先根据用户id编号查询用户信息，然后再进行修改，修改时同样需要对输入的信息进行判断，
 * 修改成功则覆盖原先用户数据。否则进行相关信息提示。查询:分为id查询和登录名称查询
 * 
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
		System.out.println(
				"                返回上一层输入6                                               退出输入7                ");
		System.out.print("请输入：");
		String s = scanner.nextLine();
		char c = s.charAt(0);
		int i = (int) c - 48;
		if (!Character.isDigit(c) || i > 7) {
			System.out.println("输入有误");
			new AdministratorManagement().main(null);

		}
		if (s.equals("1")) {
			AllAdministratorManagement();
		}
		if (s.equals("2")) {
			new AddAdministrator();
			AddAdministrator.main(null);
		}
		if (s.equals("3")) {
			new DeleteAdministrator();
			DeleteAdministrator.main(null);
		}
		if (s.equals("4")) {
			new ModifyAdministrator();
			ModifyAdministrator.main(null);
		}
		if (s.equals("5")) {
			new QueryAdministrator();
			QueryAdministrator.main(null);
		}
		if (s.equals("6")) {
			new TwoSelectThePage();
			TwoSelectThePage.main(null);
		}
		if (s.equals("7")) {
			System.out.println("");
		}
	}

	public static void AllAdministratorManagement() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt"), "utf-8"));
		String ss;
		while ((ss = br.readLine()) != null) {
			if (ss != " ") {
				System.out.println(ss);
			}
		}
		System.out.println("\n\n");
		System.out.println("                     返回上一层请输入1                退出请输入2");
		System.out.print("请输入：");
		Scanner scanner1 = new Scanner(System.in);
		String sss3 = scanner1.nextLine();
		if (sss3.equals("1")) {
			new AdministratorManagement();
			AdministratorManagement.main(null);
			;
		}
		if (sss3.equals("2")) {
			System.out.println("谢谢使用");
		}
	}
}