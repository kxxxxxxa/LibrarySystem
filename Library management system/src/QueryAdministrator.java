import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueryAdministrator {
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
/**
 * 通过 ID码 过着账号 查询信息
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------查询管理员操作---------------------------------------");
		queryAdministrator();
	}

	public static void queryAdministrator() throws IOException {
		System.out.println("                            通过ID码查找请输入1         通过账号查找请输入2");
		String str = scanner.nextLine();
		if (str.equals("1")) {
			System.out.print("用户ID码：");
			String s1 = scanner.nextLine();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
			while ((s = br.readLine()) != null) {
				if (s.indexOf("id=") != -1 && s.indexOf(",logonName=") != -1) {
					str = s.substring(s.indexOf("id=") + 3, s.indexOf(",logonName="));
				}
				if (s1.equals(str)) {
					System.out.println(s);
					System.out.println("重新查找输入1               返回上一层请输入2              退出请输入3");
					String sss3 = scanner1.nextLine();
					if (sss3.equals("1")) {
						queryAdministrator();
						break;
					} else if (sss3.equals("2")) {
						new AdministratorManagement();
						AdministratorManagement.main(null);
						break;
					} else if (sss3.equals("3")) {
						System.out.println("谢谢使用");
						break;
					}
					break;
				}
			}
		}
		if (str.equals("2")) {
			System.out.print("用户账号：");
			String s1 = scanner.nextLine();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
			while ((s = br.readLine()) != null) {
				if (s.indexOf("logonName=") != -1 && s.indexOf(", pwd=") != -1) {
					str1 = s.substring(s.indexOf("logonName=") + 10, s.indexOf(", pwd="));
				}
				if (s1.equals(str1)) {
					System.out.println(s);
					System.out.println("重新查找输入1               返回上一层请输入2              退出请输入3");
					String sss3 = scanner1.nextLine();
					if (sss3.equals("1")) {
						queryAdministrator();
						break;
					} else if (sss3.equals("2")) {
						new AdministratorManagement();
						AdministratorManagement.main(null);
						break;
					} else if (sss3.equals("3")) {
						System.out.println("谢谢使用");
						break;
					}
					break;
				}
			}
		}

	}

}
