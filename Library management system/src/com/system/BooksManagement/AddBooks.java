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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.system.AdministratorManagement.AdministratorManagement;
/**
 * 验证要求:
1.	id唯一
2.	作者如果输入的是中文则至少是两个汉字，如果输入的是英文至少需要五个字符
3.	单价只能是数字
4.	出版社只要验证非空即可
5.	出版日期默认是当前系统日期，日期格式为(YYYY-MM-dd )
6.	类别供用户选择1：java   2:.net   3:android  4:ios
 * @author xubo
 *
 */
public class AddBooks {
	static String s1, s2, s4, s5, s6;
	static double s3;
	static BufferedReader br;
	static Scanner scanner3 = new Scanner(System.in);
	static Scanner scanner1 = new Scanner(System.in);
	static Map<String, BookRegistration> msb=new HashMap<>();
	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------增加图书操作---------------------------------------");
		System.out.println("                 继续操作请输入1               返回上一层请输入2                退出请输入3");
		String sss3 = scanner1.nextLine();
		if (sss3.equals("1")) {
			addBooks();
		}
		if (sss3.equals("2")) {
			new BooksManagement();
			BooksManagement.main(null);;
		} 
		if (sss3.equals("3")) {
			System.out.println("谢谢使用");
	}
	}

	public static void addBooks() throws IOException {
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		System.out.print("书名：\r");
		s1 = scanner.nextLine();
		System.out.print("作者：\r");
		s2 = scanner.nextLine();
		System.out.print("单价：\r");
		s3 = scanner.nextDouble();
		System.out.print("出版社：\r");
		s4 = scanner1.nextLine();
		System.out.print("类别（请选着 1：java   2:.net   3:android  4:ios）：\r");
		s5 = scanner2.nextLine();
		char ch=s5.charAt(0);
		int i=(int)(ch)-48;
    	System.out.println(i);
		VerificationBooksName();
	}

	public static void VerificationBooksName() throws IOException {
		br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Registerbook.txt"), "utf-8"));
		String ss, ss1 = "", sss3;
		String[] ss2 = null;
		String str = null;
		int count = 0;
		while ((ss = br.readLine()) != null) {
			if (ss.indexOf("bookName=") != -1 && ss.indexOf(",authorName") != -1) {
				str = ss.substring(ss.indexOf("bookName=") + 9, ss.indexOf(",authorName"));
			}
			System.out.println(str);
			if (s1.equals(str)) {
				count++;
				break;
			}
		}
		if (count!=0||s1.isEmpty()) {
			System.out.println("书名不能为空，不能重复");
			System.out.println("注册失败! 请重新注册请输入1               返回上一层请输入2              退出请输入3");
			sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				addBooks();
			} else if (sss3.equals("2")) {
				new BooksManagement();
				BooksManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		}
		else {
			VerificationAuthorName();
		}
		}

    public static void VerificationAuthorName() throws IOException{
		String ss, ss1 = "", sss3;
		char[] ch;
		int count=0,count1=0;
		ch=s2.toCharArray();
		System.out.println(s2);
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLetterOrDigit(ch[i])) {
				count++;
			}
			else {
				count1++;
			}
		}
		System.out.println(count);
		if (s2.isEmpty()&&(count1>2||count>5)) {
			System.out.println("作者名不能为空");
			System.out.println("注册失败! 请重新注册请输入1               返回上一层请输入2              退出请输入3");
			sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				addBooks();
			} else if (sss3.equals("2")) {
				new BooksManagement();
				BooksManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		}
		else {
			VerificationPress();
		}
    }

    public static void VerificationPress() throws IOException{
    	if (s4.isEmpty()) {
			System.out.println("出版社不能为空");
			System.out.println("注册失败! 请重新注册请输入1               返回上一层请输入2              退出请输入3");
			String sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				addBooks();
			} else if (sss3.equals("2")) {
				new BooksManagement();
				BooksManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		}
    	else {
    		VerificationType();
		}
    }

    public static void VerificationType() throws IOException{
    	char ch=s5.charAt(0);
    	int i=(int)(ch)-48;
    	System.out.println();
    	if (i>4) {
    		System.out.println("输入错误");
			System.out.println("注册失败! 请重新注册请输入1               返回上一层请输入2              退出请输入3");
			String sss3 = scanner3.nextLine();
			if (sss3.equals("1")) {
				addBooks();
			} else if (sss3.equals("2")) {
				new BooksManagement();
				BooksManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		}
    	else{
    		dataStorage();
    	}
    	
    }
    
    public static void dataStorage() throws IOException {
		msb.put(new BookRegistration().getId(), new BookRegistration(s1, s2, s3, s4, s5));
		Collection<BookRegistration> coll = msb.values();
		for (BookRegistration registerPage : coll) {
			System.out.println("注册成功");
			System.out.println("图书的ID码：" + registerPage.getId());
			try {
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("D:\\Registerbook.txt", true),"utf-8"));
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
		msb.clear();
		System.out.println("注册成功! 继续注册请输入1               返回上一层请输入2              退出请输入3");
		String sss3 = scanner3.nextLine();
		if (sss3.equals("1")) {
			addBooks();
		} else if (sss3.equals("2")) {
			new BooksManagement();
			BooksManagement.main(null);
		} else if (sss3.equals("3")) {
			System.out.println("谢谢使用");
		}
	}

}
