package cn.edu.xjtu.neo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client for Socket
 * @author shengyuan
 *
 */

public class NeoClient {
	
	public static void main(String[] args) {
		
		Socket s = null;
		
		try {
			
			s = new Socket("127.0.0.1", 9988);
			
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw, true);
			
			pw.write("hello");
			
			pw.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (!s.isClosed()) {
				try {
					s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (!s.isClosed()) {
				try {
					s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
}
