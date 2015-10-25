package cn.itcast.client;

import com.baidu.so.soso.Person;
import com.baidu.so.soso.PersonServiceImpl;
import com.baidu.so.soso.PersonServiceImplService;

/**
 * 
 * 调用对象类型的webservice
 * @author Administrator
 *
 */
public class PersonServiceInvoke {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PersonServiceImpl personService=new PersonServiceImplService().getPersonServiceImplPort();

		Person person=personService.findPersonById(1);
		
		System.out.println(person.getUsername());
	}

}
