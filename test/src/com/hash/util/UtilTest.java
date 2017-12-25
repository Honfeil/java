package com.hash.util;

import java.io.UnsupportedEncodingException;

/**
 * @author:hash
 * @date:2017年12月18日下午10:30:32
 * @Description:自定义工具类
 */
public class UtilTest {

	public static int getBiggerComDivisor(int i, int j) {
		return j == 0 ? i : getBiggerComDivisor(j, i % j);
	}

	/**
	 * 整数绝对值
	 * 
	 * @param x  int值
	 * @return 返回绝对值
	 */
	public static byte[]  getAbsVue(String str) {
		byte[] bytes = null;
		try {
			bytes = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
		
	}

	/**
	 * 浮点绝对值
	 * 
	 * @param x
	 * @return
	 */
	public static double getAbsVue(double x) {
		return x <= 0 ? -x : x;
	}
}
