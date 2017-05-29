package com.system.test;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class RemoveImage {
	public static void main(String[] args) {
		Map<Integer, String> map=new LinkedHashMap<>();
		int count=0;
		char[] ch;
		int c=0;
		try {
			BufferedReader be=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Register.txt")));
			String s;
			while((s=be.readLine())!=null){
			if (s.indexOf("=")!=-1&&s.indexOf(',')!=-1) {
				String str=s.substring(s.indexOf("=")+1, s.indexOf(','));
				ch=str.toCharArray();
				int t=ch.length;
				for (int i = 0; i < ch.length; i++) {
					char f=ch[i];
					c+=(int) (((int)f-48)*Math.pow(10, t-i-1));
				}
				count=c;
				c=0;
			}
			map.put(count, s);
			}
			Set<Integer> set=map.keySet();
			Iterator<Integer> iter=set.iterator();
			while(iter.hasNext()){
				System.out.println(map.get(iter.next()));
			}
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
