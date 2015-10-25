package cn.itcast.client;

import com.baidu.letv.MobileCodeWS;
import com.baidu.letv.MobileCodeWSSoap;

/**
 * 
 * 调用互联网上手机号码归属地的服务...
 * @author Administrator
 *
 */
public class TelephoneInvoke {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MobileCodeWSSoap codeWSSoap=new MobileCodeWS().getMobileCodeWSSoap();
		String address=codeWSSoap.getMobileCodeInfo("18888888888", "");
		System.out.println(address);
		address=codeWSSoap.getMobileCodeInfo("18611478781", "");
		System.out.println(address);
		address=codeWSSoap.getMobileCodeInfo("13761603061", "");
		System.out.println(address);
	}

}
