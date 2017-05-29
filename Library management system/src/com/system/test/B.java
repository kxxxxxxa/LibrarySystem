package com.system.test;

import java.util.ArrayList;
import java.util.List;

public class B {
	public static void main(String[] args) {
		b(new A().a());
	}
	public static void b(List<String> list){
		list=new ArrayList<String>();
		for (String string : list) {
			System.out.println(string);
		}
	}

}
