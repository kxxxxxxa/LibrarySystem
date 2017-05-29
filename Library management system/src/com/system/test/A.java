package com.system.test;

import java.util.ArrayList;
import java.util.List;

public class A {
	public static void main(String[] args) {
	}
	public static List a(){
		List<String> list= new ArrayList<>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}

}
