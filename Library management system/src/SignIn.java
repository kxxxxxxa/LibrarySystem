import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SignIn {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------�û���¼---------------------------------------");
		signIn();
	}
	public static void signIn() throws IOException{
		String s;
		String ss;
		ss = initcode();
		int count = 0;
		char[] ch;
		int c = 0;
		String ss1 = null;
		String[] ss2;
		BufferedReader be = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
		while ((s = be.readLine()) != null) {
			if (s.indexOf("logonName=") != -1 && s.indexOf(", pwd=") != -1) {
				String str = s.substring(s.indexOf("logonName=") + 10, s.indexOf(", pwd="));
				ss1 += str + " ";
			}
			if (s.indexOf("pwd=") != -1 && s.indexOf(", gender") != -1) {
				String str = s.substring(s.indexOf("pwd=") + 4, s.indexOf(", gender"));
				ss1 += str + " ";
			}
		}
		System.out.print("��¼���ƣ�");
		String s0 = scanner.nextLine();
		System.out.print("���룺");
		String s1 = scanner.nextLine();
		System.out.println("��֤�룺" + ss);
		System.out.print("��������֤�룺");
		String s2 = scanner.nextLine();
		System.out.println("��֤��¼ģʽ ");
		ss2 = ss1.split(" ");
		for (int i = 0; i < ss2.length; i++) {
			if (s0.equals(ss2[i])) {
				count++;
			}
			if (s1.equals(ss2[i])) {
				count++;
			}
		}
		if (count >= 2) {
			if (s2.equals(ss)) {
				System.out.println("��½�ɹ�");
			}
		}
		else {
			System.out.println("��¼ʧ��! �����������˺�����");
			System.out.println("��������������3");
			System.out.println("�˳�������4");
			System.out.println("������һ��������5");
			String sss3=scanner.nextLine();
			if (sss3.equals("3")) {
				new ForgotPwd();
				ForgotPwd.forgotPwd();
			}
			else if (sss3.equals("4")) {
				System.out.println("�����˳�");
			}
			else if (sss3.equals("5")) {
				
			}
			else {
				signIn();
			}
			
		}

	}

	public static String initcode() {
		Random random = new Random();
		int count = 0;
		char[] s;
		String d = "";
		String str = "1234567890abcdefghijklmnopqrstuvwsyz";
		while (true) {

			char a = str.charAt(random.nextInt(26));
			if (d.indexOf(a, 0) == -1) {
				d += a;
				count++;
			}
			if (count == 6) {
				break;
			}
		}
		char[] c1 = d.toCharArray();
		Arrays.sort(c1);
		return d;

	}

}
