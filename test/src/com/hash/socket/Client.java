package com.hash.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
*@author:hash
*@date:2017年12月19日上午10:03:01
*@Description:TODO
*/
public class Client {
	//设定主机地址和端口号
	private static String HOST = "localhost";
	private static int PORT = 12345;
	//设定socket，用于传输
	private Socket socket = null;
	//设定PrintWrite，用于发送信息
	PrintWriter sendMsg = null;
	//设定BuffredReader，用于接收读取信息
	BufferedReader getMsg = null;
	
	/**
	 * 初始化方法
	 * 初始化socket、PrintWrite、BuffredReader
	 */
	public void init() {
		try {
			//初始化socket
			socket = new Socket(HOST, PORT);
			//初始化PrintWriter,默认自动刷新开启
			sendMsg = new PrintWriter(socket.getOutputStream(), true);
			//初始化BufferedReader
			getMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("------无法找到网络主机，请检查地址------");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 发送请求到服务器，并且接受返回值
	 * @param request 请求字符串
	 * @return response 响应字符串(建议JSON格式)
	 */
	public String sendReqToServer(String req) {
		//初始化使用参数
		init();
		//初始化响应
		String resp = "";
		try {
			//PrintWriter发送请求
			sendMsg.println(req);
			sendMsg.flush();
			//BufferedReader读取响应
			resp = getMsg.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("------读取响应失败------");
			e.printStackTrace();
		}finally {
			close();
		}
		return resp;
	}
	
	/**
	 * 用于关闭资源
	 */
	public void close() {
		if (getMsg!=null) {
			try {
				getMsg.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if (sendMsg!=null) {
			sendMsg.close();			
		}
		if (socket!=null) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	public static void main(String[] args) throws Exception {
		String resp = new Client().sendReqToServer(new Date()+":我是来自客户端的请求");
		System.out.println(resp);
	}
}
