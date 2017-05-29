package com.system.BooksManagement;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.system.AdministratorManagement.AdministratorManagement;
/**
 * 通过ID码 匹配删除数据
 * @author xubo
 *
 */
public class DeleteBooks {
	static String s2, s4, s5, s6,ss,str;
	static double s3;
	static BufferedReader br;
	static Scanner scanner3 = new Scanner(System.in);
	static Scanner scanner1 = new Scanner(System.in);
	static List<String> list = new ArrayList<>();
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------增加图书操作---------------------------------------");
		System.out.println("          继续操作请输入1               返回上一层请输入2                退出请输入3");
		String sss3 = scanner1.nextLine();
		char c=sss3.charAt(0);
		int i=(int)c-48;
		if (!Character.isDigit(c)||i>3) {
			System.out.println("输入有误");
			new DeleteBooks().main(null);;
			
		}
		if (sss3.equals("1")) {
			deleteBooks();
		}
		if (sss3.equals("2")) {
			new BooksManagement();
			BooksManagement.main(null);;
		} 
		if (sss3.equals("3")) {
			System.out.println("谢谢使用");
	}
	}
	public static void deleteBooks() throws IOException{
		int count=0;
		String sss3;
		System.out.println("输入要删除的ID码：");
		String s1=scanner3.nextLine();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Registerbook.txt"), "utf-8"));
		while ((ss = br.readLine()) != null) {
			System.out.println(ss);
			if (ss.indexOf("id=") != -1 && ss.indexOf(", bookName") != -1) {
				str = ss.substring(ss.indexOf("id=") + 3, ss.indexOf(", bookName"));
				System.out.println(str);
			}
			if (s1.equals(str)) {
				count++;
			}
			else {
				list.add(ss);
			}
		}
		if (count!=0) {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Registerbook.txt"),"utf-8"));
			for (String string : list) {
				bw.newLine();
				bw.write(string);
				bw.flush();
			}
			list .clear();
			System.out.println("删除成功! 继续请输入1               返回上一层请输入2              退出请输入3");
			sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				deleteBooks();
			} else if (sss3.equals("2")) {
				new BooksManagement();
				BooksManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		}
		else {
			System.out.println("ID码未找到");
			System.out.println("删除失败! 继续请输入1               返回上一层请输入2              退出请输入3");
			sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				deleteBooks();
			} else if (sss3.equals("2")) {
				new BooksManagement();
				BooksManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		}
	}

}
