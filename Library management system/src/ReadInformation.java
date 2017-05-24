import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ReadInformation {
	public static void main(String[] args) {
		LinkedList<String> list = list=new LinkedList<>();
		int count=0;
		try {
			BufferedReader be=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
			String s;
			while((s=be.readLine())!=null){
				count++;
				list.add(s);
			}
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
		
	}

}
