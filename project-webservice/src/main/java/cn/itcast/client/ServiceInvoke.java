package cn.itcast.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import cn.itcast.service.PersonServiceImpl;

/**
 * 
 * 通过客户端编程的方式调用。。。
 * 
 * 通过service 调用需要依赖一个接口，这个接口可以从wsimport 生成的代码当中获取....
 * @author Administrator
 *
 */
public class ServiceInvoke {
	public static void main(String[] args) throws MalformedURLException {
		/**
		 * 
		 * 服务说明书的地址。。。
		 */
		URL wsdlDocumentLocation=new URL("http://192.168.1.100:9527/personService?wsdl");
		String namespace="http://service.itcast.cn/";
		/**
		 * 用于定位服务...
		 * 
		 */
		QName serviceName=new QName(namespace, "PersonServiceImplService");
		
		//创建服务...
		Service service=Service.create(wsdlDocumentLocation, serviceName);
		
		//wsimport 生成的代码也是通过改造了Service的一个类，去获取接口。。。
		
		PersonServiceImpl personService=service.getPort(new QName(namespace, "PersonServiceImplPort"), PersonServiceImpl.class);
		
		String data=personService.getData();
		
		System.out.println(data);
		
	}
}
