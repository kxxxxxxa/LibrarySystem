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
import java.util.List;
import java.util.Scanner;

import com.system.AdministratorManagement.AdministratorManagement;
/**
 * 通过ID码 匹配修改数据
 * @author xubo
 *
 */
public class ModifyBooks {
	static String s2, s4, s5, s6, ss, str,strrr;
	static double s3;
	static BufferedReader br;
	static Scanner scanner3 = new Scanner(System.in);
	static Scanner scanner1 = new Scanner(System.in);
	static List<String> list = new ArrayList<>();
	static List<String> list1 = new ArrayList<>();
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------增加图书操作---------------------------------------");
		System.out.println("          继续操作请输入1               返回上一层请输入2                退出请输入3");
		String sss3 = scanner1.nextLine();
		if (sss3.equals("1")) {
				modifyBooks();
		}
		if (sss3.equals("2")) {
			new BooksManagement();
			BooksManagement.main(null);;
		} 
		if (sss3.equals("3")) {
			System.out.println("谢谢使用");
	}
	}

	public static void modifyBooks() throws IOException {
		int count = 0;
		String sss3;
		System.out.println("输入要修改的ID码：");
		String s1 = scanner3.nextLine();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Registerbook.txt"), "utf-8"));
		while ((ss = br.readLine()) != null) {
			if (ss.indexOf("id=") != -1 && ss.indexOf(", bookName") != -1) {
				str = ss.substring(ss.indexOf("id=") + 3, ss.indexOf(", bookName"));
				System.out.println(str);
			}
			if (s1.equals(str)) {
				strrr=ss;
				count++;
			} else {
				list.add(ss);
			}
		}
		if (count != 0) {
			System.out.println("ID码验证成功");
			System.out.println("原始信息：" + strrr);
			System.out.println("重新设置输入1               返回上一层请输入2              退出请输入3");
			sss3 = scanner1.nextLine();
			if (sss3.equals("1")) {
				modificationBooks();
			} else if (sss3.equals("2")) {
				new BooksManagement();
				BooksManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		}
	}

	public static void modificationBooks() throws IOException {
		System.out.println("修改书名请输入1     修改作者请输入2    修改价格请输入3    ");
		String strr = scanner1.nextLine();
		String s1, str2 = null;
		if (strr.equals("1")) {
			list1.addAll(list);
			System.out.println("输入新的账号：");
			String sss0 = scanner1.nextLine();
			String sstr1 = null, sstr = null;
			int count01 = 0;
			br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Registerbook.txt"), "utf-8"));
			while ((s1 = br.readLine()) != null) {
				if (s1.indexOf("bookName=") != -1 && s1.indexOf(",authorName") != -1) {
					str2 = s1.substring(s1.indexOf("bookName=") + 9, s1.indexOf(",authorName"));
				}
				if (sss0.equals(str2)) {
					count01++;
					break;
				}
			}
			if (count01 == 0) {
				strrr = strrr.substring(0, (strrr.indexOf("bookName=") + 9)) + sss0+ strrr.substring(strrr.indexOf(",author"), strrr.indexOf("type") + 10);
				list1.add(strrr);
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Registerbook.txt")));
				for (String string : list1) {
					bw.newLine();
					bw.write(string);
					bw.flush();
				}
				list1.clear();
				System.out.println("账号修改成功");
				System.out.println("修改其他或重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					modificationBooks();
				} else if (sss3.equals("2")) {
					new BooksManagement();
					BooksManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			} else {
				System.out.println("账号修改失败，书名重复");
				System.out.println("修改其他或重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					modificationBooks();
				} else if (sss3.equals("2")) {
					new BooksManagement();
					BooksManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			}
		}
		if (strr.equals("2")) {
			list1.addAll(list);
			System.out.println("输入新的作者：");
			String sss0 = scanner1.nextLine();
			String sstr1 = null, sstr = null;
			int count01 = 0;
			br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Registerbook.txt"), "utf-8"));
			while ((s1 = br.readLine()) != null) {
				if (s1.indexOf("authorName=") != -1 && s1.indexOf(", price=") != -1) {
					str2 = s1.substring(s1.indexOf("authorName=") + 5, s1.indexOf(", price="));
				}
				if (sss0.equals(str2)) {
					count01++;
					break;
				}
			}
			if (count01 == 0) {
				strrr = strrr.substring(0, (strrr.indexOf("authorName=") + 11)) + sss0+ strrr.substring(strrr.indexOf(", price"), strrr.indexOf("type") + 10);
				list1.add(strrr);
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Registerbook.txt")));
				for (String string : list1) {
					bw.newLine();
					bw.write(string);
					bw.flush();
				}
				list1.clear();
				System.out.println("作者修改成功");
				System.out.println("修改其他或重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					modificationBooks();
				} else if (sss3.equals("2")) {
					new BooksManagement();
					BooksManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			} else {
				System.out.println("作者修改失败，书名重复");
				System.out.println("修改其他或重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					modificationBooks();
				} else if (sss3.equals("2")) {
					new BooksManagement();
					BooksManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			}
		}
		if (strr.equals("3")) {
			list1.addAll(list);
			System.out.println("输入新的价格：");
			String sss0 = scanner1.nextLine();
			String sstr1 = null, sstr = null;
			int count01 = 0;
			br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Registerbook.txt"), "utf-8"));
			while ((s1 = br.readLine()) != null) {
				if (s1.indexOf("price=") != -1 && s1.indexOf(", press") != -1) {
					str2 = s1.substring(s1.indexOf("price=") + 5, s1.indexOf(", press"));
				}
				if (sss0.equals(str2)) {
					count01++;
					break;
				}
			}
			if (count01 == 0) {
				strrr = strrr.substring(0, (strrr.indexOf("price=") + 6)) + sss0+ strrr.substring(strrr.indexOf(", press"), strrr.indexOf("type") + 10);
				list1.add(strrr);
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Registerbook.txt")));
				for (String string : list1) {
					bw.newLine();
					bw.write(string);
					bw.flush();
				}
				list1.clear();
				System.out.println("价格修改成功");
				System.out.println("修改其他或重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					modificationBooks();
				} else if (sss3.equals("2")) {
					new BooksManagement();
					BooksManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			} else {
				System.out.println("价格修改失败，书名重复");
				System.out.println("修改其他或重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					modificationBooks();
				} else if (sss3.equals("2")) {
					new BooksManagement();
					BooksManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			}
		}
	}

}
