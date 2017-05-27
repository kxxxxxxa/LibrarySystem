package com.system.BooksManagement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.system.AdministratorManagement.AddAdministrator;
import com.system.AdministratorManagement.AdministratorManagement;
import com.system.AdministratorManagement.DeleteAdministrator;
import com.system.AdministratorManagement.ModifyAdministrator;
import com.system.AdministratorManagement.QueryAdministrator;
import com.system.MainAdministrator.SignIn;
import com.system.MainAdministrator.*;
/**
 * 	图书管理:
前提条件:只有登录成功才可以进行对图书的操作。
图书管理:添加，删除，修改，查询
添加图书:需要用户输入id,图书名称，作者，单价，出版社，出版日期，类别,，并且需要验证:
验证要求:
1.	id唯一
2.	作者如果输入的是中文则至少是两个汉字，如果输入的是英文至少需要五个字符
3.	单价只能是数字
4.	出版社只要验证非空即可
5.	出版日期默认是当前系统日期，日期格式为(YYYY-MM-dd )
6.	类别供用户选择1：java   2:.net   3:android  4:ios
所有的信息验证通过时，需要把这些信息给图书JavaBean对象 "\r\n"
	删除图书:根据图书ID进行删除，

 * @author xubo
 *
 */
public class BooksManagement {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------图书信息管理中心---------------------------------------");
		System.out.println("\n");
		System.out.println(
				"                                   显示所有图书信息输入-----------------1                                   ");
		System.out.println(
				"                增加管理员输入2                                              删除管理员输入3                ");
		System.out.println(
				"                修改管理员输入4                                              查询管理员输入5                ");
		System.out.println(
				"                返回上一层输入6                                                        退出输入7                ");
		System.out.print("请输入：");
		String s = scanner.nextLine();
		if (s.equals("1")) {
			AllBook();
		}
		if (s.equals("2")) {
			new AddBooks();
			AddBooks.main(null);
		}
		if (s.equals("3")) {
			new DeleteBooks();
			DeleteBooks.main(null);
		}
		if (s.equals("4")) {
			new ModifyBooks();
			ModifyBooks.main(null);
		}
		if (s.equals("5")) {
			new QueryBooks();
			QueryBooks.main(null);
		}
		if (s.equals("6")) {
			new TwoSelectThePage();
			TwoSelectThePage.main(null);
		}
		if (s.equals("7")) {
			System.out.println("谢谢使用");
		}
	}
	public static void AllBook() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Registerbook.txt"), "utf-8"));
		String ss;
		while ((ss = br.readLine()) != null) {
			if (ss!=" ") {
				System.out.println(ss);
			}
			}
		System.out.println("\n\n");
		System.out.println("                     返回上一层请输入1                退出请输入2");
		System.out.print("请输入：");
		Scanner scanner1=new Scanner(System.in);
		String sss3 = scanner1.nextLine();
		if (sss3.equals("1")) {
			new BooksManagement();
			BooksManagement.main(null);;
		} 
		if (sss3.equals("2")) {
			System.out.println("谢谢使用");
	}
		}
	}


