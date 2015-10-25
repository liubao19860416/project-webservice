package cn.itcast.client;

import cn.itcast.hello.HelloService;
import cn.itcast.hello.HelloServiceService;

/**
 * 
 * 我们可以使用 java jdk 自带的命令 wsimport
 * 
 * wsimport 命令的作用：根据服务说明书的地址生成本的Java代码，
 * 然后我们操作这些java代码就可以调用我的webservice 程序...
 * 
 * 
 * wsimport 怎么去用：
 * @author Administrator
 *
 */
public class ClientInvoke {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//找到继承了service 的类...
		
		HelloServiceService service=new HelloServiceService();
		//找到接口
		
		HelloService helloService=service.getHelloServicePort();
		
		String data=helloService.getData();
		System.out.println(data);
		
		
	}

}
