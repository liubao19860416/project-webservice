package cn.itcast.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * 因为对于服务端来说，不需要管客户端是使用什么调用的，它只人数据格式
 * 
 * webservice 的客户端与服务端进行交互走的是soap 协议。。
 * 
 * soap 协议 是在http 的基础传送xml 格式的数据
 * 
 * 
 * 在java里面 有一个类可以用来发送http 请求... 我们只需要在这个请求上把xml 格式的数据发送到服务端
 * 
 * 我们就能完成调用...
 * @author Administrator
 *
 */
public class URLConnectionInvoke {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
			
		URL url=new URL("http://192.168.1.100:8090/helloService");
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		//因为服务端接受的是xml 格式的数据，那么我需要设置text/xml;charset=UTF-8
		connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
		
		//要往服务端发送数据,接受数据...
		connection.setDoInput(true);
		connection.setDoOutput(true);
//		/设置提交方式为post...
		connection.setRequestMethod("POST");
		OutputStream outputStream=connection.getOutputStream();
		StringBuffer buffer=new StringBuffer(5000);
		buffer.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hel=\"http://hello.itcast.cn/\">")
		.append("<soapenv:Header/><soapenv:Body><hel:getData/></soapenv:Body></soapenv:Envelope>");
		outputStream.write(buffer.toString().getBytes());
		InputStream is=connection.getInputStream();
		byte [] b=new byte [1024];
		int length=0;
		StringBuffer sb=new StringBuffer();
		while((length=is.read(b))!=-1){
			String string=new String(b,0,length);
			sb.append(string);
		}
		System.out.println(sb.toString());
	}

}
