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

import com.system.MainAdministrator.SignIn;
/**
 * 修改:先根据用户id编号查询用户信息，然后再进行修改，修改时同样需要对输入的信息进行判断，修改成功则覆盖原先用户数据。否则进行相关信息提示。
 * 判断条件和之前注册条件一致
 * @author xubo
 *
 */
public class ModifyAdministrator {
	static Scanner scanner = new Scanner(System.in);
	static String s2 = null, ss;
	static int count = 0;
	static String ss1 = null;
	static String[] ss2;
	static String s0;
	static BufferedReader br, be;
	static Scanner scanner1 = new Scanner(System.in);
	static Scanner scanner3 = new Scanner(System.in);
	static List<String> list = new ArrayList<>();
	static List<String> list1 = new ArrayList<>();
	static String s, s1, str = null, str1 = null, str2 = null;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------修改管理员操作---------------------------------------");
		System.out.println("                 修改请输入1               返回上一层请输入2                退出请输入3");
		String sss3 = scanner1.nextLine();
		char c=sss3.charAt(0);
		int i=(int)c-48;
		if (!Character.isDigit(c)||i>3) {
			System.out.println("输入有误");
			new ModifyAdministrator().main(null);;
			
		}
		if (sss3.equals("1")) {
			forgotPwd();
		}
		if (sss3.equals("2")) {
			new AdministratorManagement();
			AdministratorManagement.main(null);;
		} 
		if (sss3.equals("3")) {
			System.out.println("谢谢使用");
	}
		
	}

	// forgotPwd();功能是 通过 账号+ID码与文本中的数据进行比对 都通过进行密码的找回 并显示原密码
	public static void forgotPwd() throws IOException {
		System.out.print("输入修改用户ID码：");
		String s1 = scanner.nextLine();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("id=") != -1 && s.indexOf(",logonName=") != -1) {
				str = s.substring(s.indexOf("id=") + 3, s.indexOf(",logonName="));
			}
			if (s1.equals(str)) {
				str2 = s;
				count++;
			} else {
				list.add(s);
			}
		}
		if (count != 0) {
			list.clear();
			System.out.println("ID码验证成功");
			System.out.println("原始信息：" + str2);
			System.out.println("重新设置输入1               返回上一层请输入2              退出请输入3");
			String sss3 = scanner1.nextLine();
			if (sss3.equals("1")) {
				resetPassword();
			} else if (sss3.equals("2")) {
				new AdministratorManagement();
				AdministratorManagement.main(null);;
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		} else {
			System.out.println("验证错误： 账号与ID码不匹配");
			System.out.println("重新输入ID1               返回上一层请输入2              退出请输入3");
			String sss3 = scanner1.nextLine();
			if (sss3.equals("1")) {
				forgotPwd();
			} else if (sss3.equals("2")) {
				new AdministratorManagement();
				AdministratorManagement.main(null);
			} else if (sss3.equals("3")) {
				System.out.println("谢谢使用");
			}
		}
	}

	// 账号+ID码的验证通过后，推荐用户进行修改密码的操作 修改的密码不能与原密码相同 如果相同提示用户重设密码
	public static void resetPassword() throws IOException {
		System.out.println("修改账号请输入1     修改密码请输入2    修改名字请输入3    修改地址请输入4    修改电话请输入5");
		String str = scanner1.nextLine();
		if (str.equals("1")) {
			list1.addAll(list);
			int count = 0;
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			int count4 = 0;
			int count5 = 0;
			System.out.println("输入新的账号：");
			String sss0 = scanner.nextLine();
			String sstr1 = null, sstr = null;
			int count01 = 0;
			be = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt"), "utf-8"));
			while ((s1 = be.readLine()) != null) {
				if (s1.indexOf("logonName=") != -1 && s1.indexOf(", pwd=") != -1) {
					sstr = s1.substring(s1.indexOf("logonName=") + 10, s1.indexOf(", pwd="));
				}
				if (sss0.equals(sstr)) {
					count01++;
					break;
				}
			}
			if (count01 == 0) {
				char[] ch1 = sss0.toCharArray();
				if (sss0.length() > 8 || sss0.length() < 3) {
					System.out.println(1);
					System.out.println("用户名长度在3-8位");
					System.out.println("修改失败! 重新修改请输入1               返回上一层请输入2              退出请输入3");
					String sss3 = scanner3.nextLine();
					if (sss3.equals("1")) {
						resetPassword();
					} else if (sss3.equals("2")) {
						new AdministratorManagement();
						AdministratorManagement.main(null);
					} else if (sss3.equals("3")) {
						System.out.println("谢谢使用");
					}
					for (int i = 0; i < ch1.length; i++) {
						if (Character.isDigit(ch1[0])) {
							System.out.println("登录名称首位不能使数字,登录名称用英文 数字 符号组成");
							System.out.println("修改失败! 重新修改请输入1               返回上一层请输入2              退出请输入3");
							sss3 = scanner3.nextLine();
							if (sss3.equals("1")) {
								resetPassword();
								break;
							} else if (sss3.equals("2")) {
								new AdministratorManagement();
								AdministratorManagement.main(null);
								break;
							} else if (sss3.equals("3")) {
								System.out.println("谢谢使用");
								break;
							}
							if (Character.isDigit(ch1[i])) {
								count1++;
							}
							if (Character.isLetter(ch1[i])) {
								count2++;
							}
							if (!Character.isLetterOrDigit(ch1[i])) {
								count3++;
							}
						}
					}
					if (count1 == 0 || count2 == 0 || count3 == 0) {
						System.out.println("登录名称首位不能使数字,登录名称用英文 数字 符号组成");
						System.out.println("修改失败! 重新修改请输入1               返回上一层请输入2              退出请输入3");
						sss3 = scanner3.nextLine();
						if (sss3.equals("1")) {
							resetPassword();
						} else if (sss3.equals("2")) {
							new AdministratorManagement();
							AdministratorManagement.main(null);
						} else if (sss3.equals("3")) {
							System.out.println("谢谢使用");
						}
					}
				} else {
					str2 = str2.substring(0, (str2.indexOf("logonName=") + 10)) + sss0
							+ str2.substring(str2.indexOf(", pwd"), str2.indexOf("正常") + 3);
					list1.add(str2);
					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Register.txt")));
					for (String string : list1) {
						bw.newLine();
						bw.write(string);
						bw.flush();
						System.out.println(string);
					}

					list1.clear();
					System.out.println("密码修改成功");
					System.out.println("修改其他或重新修改请输入1               返回上一层请输入2              退出请输入3");
					String sss3 = scanner3.nextLine();
					if (sss3.equals("1")) {
						resetPassword();
					} else if (sss3.equals("2")) {
						new AdministratorManagement();
						AdministratorManagement.main(null);
					} else if (sss3.equals("3")) {
						System.out.println("谢谢使用");
					}
				}

			}
		}

		if (str.equals("2")) {
			list1.addAll(list);
			System.out.println("输入新的密码：");
			String sss0 = scanner.nextLine();
			String sstr1 = null, sstr = null;
			int count01 = 0;
			be = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt"), "utf-8"));
			// while ((s1 = be.readLine()) != null) {
			// if (s1.indexOf("pwd=") != -1 && s1.indexOf(", gender") != -1) {
			// sstr = s1.substring(s1.indexOf("pwd=") + 4, s1.indexOf(",
			// gender"));
			// }
			// if (sss0.equals(sstr)) {
			// count01++;
			// break;
			// }
			//
			// }
			if (sss0.length() > 12 || sss0.length() < 6 || count01 == 1) {
				System.out.println("密码长度在6-12位,且不能与原密码相同");
				System.out.println("修改失败! 重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					resetPassword();
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			} else {
				str2 = str2.substring(0, (str2.indexOf("pwd=") + 4)) + sss0
						+ str2.substring(str2.indexOf(", gender"), str2.indexOf("正常") + 3);
				list1.add(str2);
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Register.txt")));
				for (String string : list1) {
					bw.newLine();
					bw.write(string);
					bw.flush();
				}
				list1.clear();
				System.out.println("密码修改成功");
				System.out.println("修改其他或重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					resetPassword();
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			}

		}
		if (str.equals("3")) {
			list1.addAll(list);
			System.out.println("输入新的密码：");
			String sss0 = scanner.nextLine();
			String sstr1 = null, sstr = null;
			int count01 = 0;
			if (sss0.isEmpty()) {
				System.out.println("名字不能为空");
				System.out.println("修改失败! 重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					resetPassword();
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			}
			else {
				str2 = str2.substring(0, (str2.indexOf("name=") + 4)) + sss0
						+ str2.substring(str2.indexOf(", age="), str2.indexOf("正常") + 3);
				list1.add(str2);
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Register.txt")));
				for (String string : list1) {
					bw.newLine();
					bw.write(string);
					bw.flush();
				}
				list1.clear();
				System.out.println("姓名修改成功");
				System.out.println("修改其他或重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					resetPassword();
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			}

		}
		if (str.equals("4")) {
			list1.addAll(list);
			System.out.println("输入新的地址：");
			String sss0 = scanner.nextLine();
			String sstr1 = null, sstr = null;
			int count01 = 0;
			if (sss0.isEmpty()) {
				System.out.println("地址不能为空");
				System.out.println("修改失败! 重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					resetPassword();
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			}
			else {
				str2 = str2.substring(0, (str2.indexOf("pwd=") + 4)) + sss0
						+ str2.substring(str2.indexOf(", gender"), str2.indexOf("正常") + 3);
				list1.add(str2);
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Register.txt")));
				for (String string : list1) {
					bw.newLine();
					bw.write(string);
					bw.flush();
				}
				list1.clear();
				System.out.println("密码修改成功");
				System.out.println("修改其他或重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					resetPassword();
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			}

		}
		if (str.equals("5")) {
			list1.addAll(list);
			System.out.println("输入新的电话：");
			String sss0 = scanner.nextLine();
			String sstr1 = null, sstr = null;
			int count01 = 0;
			if (sss0.length() != 11) {
				System.out.println("电话号码必须都是数字而且是11位");
				System.out.println("修改失败! 重新修改请输入1               返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					resetPassword();
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			}
			else {
				str2 = str2.substring(0, (str2.indexOf("tell=") + 5)) + sss0
						+ str2.substring(str2.indexOf(", type"), str2.indexOf("正常") + 3);
				list1.add(str2);
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Register.txt")));
				for (String string : list1) {
					bw.newLine();
					bw.write(string);
					bw.flush();
				}
				list1.clear();
				System.out.println("密码修改成功");
				System.out.println("修改其他或重新修改请输入1              返回上一层请输入2              退出请输入3");
				String sss3 = scanner3.nextLine();
				if (sss3.equals("1")) {
					resetPassword();
				} else if (sss3.equals("2")) {
					new AdministratorManagement();
					AdministratorManagement.main(null);
				} else if (sss3.equals("3")) {
					System.out.println("谢谢使用");
				}
			}

		}
	}
}
