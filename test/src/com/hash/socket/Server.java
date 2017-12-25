package com.hash.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
*@author:hash
*@date:2017年12月19日上午10:32:18
*@Description:TODO
*/
public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(12345);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);
		String line = reader.readLine();
		System.out.println(line);
		PrintWriter sendMsg = new PrintWriter(socket.getOutputStream(),true);
		sendMsg.println("hello world");
		
	}
}
