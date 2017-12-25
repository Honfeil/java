package com.hash.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new FileReader("C:\\Users\\15552\\Desktop\\HASH.txt"));
		String str = null;
		while ((str = bReader.readLine())!=null) {
				System.out.println(str);
		}
	}
}
