package cn.itcast.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class MySocket {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket=new Socket("192.168.1.100",8080);
		OutputStream os=socket.getOutputStream();
		String requestBody="hello";//<xml></xml>
		os.write(requestBody.getBytes());
		os.close();
		
	}

}
