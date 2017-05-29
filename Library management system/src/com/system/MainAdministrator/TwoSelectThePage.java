package com.system.MainAdministrator;

import java.io.IOException;
import java.util.Scanner;
import com.system.*;
import com.system.AdministratorManagement.AdministratorManagement;
import com.system.BooksManagement.BooksManagement;
/*
 * 登录成功后进入的管理员选着界面
 */
public class TwoSelectThePage {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------管理选着页面---------------------------------------");
		System.out.println("\n");
		System.out.println("                         管理员管理输入1                         图书管理输入2");
		System.out.println("                         返回上一层输入3                         退出输入4                                  ");
		System.out.print("请输入：");
		String s = scanner.nextLine();
		char c=s.charAt(0);
		int i=(int)c-48;
		if (!Character.isDigit(c)||i>4) {
			System.out.println("输入有误");
			new TwoSelectThePage().main(null);;
			
		}
		if (s.equals("1")) {
			new AdministratorManagement();
			AdministratorManagement.main(null);
		}
		if (s.equals("2")) {
			new BooksManagement();
			BooksManagement.main(null);
		}
		if (s.equals("3")) {
			new SignIn();
			SignIn.main(null);
		}
		if (s.equals("4")) {
			System.out.println("谢谢使用");
		}
	}

}
