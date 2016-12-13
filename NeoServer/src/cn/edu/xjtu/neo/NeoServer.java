package cn.edu.xjtu.neo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NeoServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket ss = null;
		try {
			
			ss = new ServerSocket(9988);
			
			Socket socket = ss.accept();
			System.out.println("Server listening ...");
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println(">> " + br.readLine());
			
			br.close();
			isr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (!ss.isClosed()) {
				try {
					ss.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
