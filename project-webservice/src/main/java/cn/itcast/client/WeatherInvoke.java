package cn.itcast.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.axis.message.SOAPEnvelope;

/**
 * 
 * 调用互联网天气预报的服务..是用urlConnection
 * 
 * @author Administrator
 *
 */
public class WeatherInvoke {

	/**
	 * @param args
	 * @throws Exception 
	 */
    public static void main(String[] args) throws Exception {
//        String data = new WeatherInvoke().getWeather("上海");
//        System.out.println(data);
        
//        String data = new WeatherInvoke().getInfoByMobilePhone("18611478781");
//        System.out.println(data);
        
//        String data = new WeatherInvoke().getInfoByMobilePhone2("18611478781");
//        System.out.println(data);
        
//        String data = new WeatherInvoke().getRegionProvince();
//        System.out.println(data);
        
//        String data = new WeatherInvoke().getDetailInfoByTrainCode("T101");
//        System.out.println(data);
        
//        String data = new WeatherInvoke().getAddressByZipCode("073100");
//        System.out.println(data);
        
//        String data = new WeatherInvoke().getEnCnTwoWayTranslator("你好");
//        System.out.println(data);
//        data = new WeatherInvoke().getEnCnTwoWayTranslator("shit");
//        System.out.println(data);
        
//        String data = new WeatherInvoke().LocateByAddress("北京","海淀");
//        System.out.println(data);
        
        //商用或试用的authkey，无authkey参数情况下每小时访问仅限20次
        String data = new WeatherInvoke().getGeneralExpressInfo("968691645538","sto","7ee2ab12b50747ff94e40d9f8def9138");
        System.out.println(data);
        
//        String data = new WeatherInvoke().getIdCardInfo("13063419850416313X","7ee2ab12b50747ff94e40d9f8def9138");
//        System.out.println(data);
        
        
        /*String endpoint = "http://webservice.webxml.com.cn/WebServices/TrainTimeWebService";
        org.apache.axis.client.Service service = new org.apache.axis.client.Service();
        org.apache.axis.client.Call call = (org.apache.axis.client.Call) service
                .createCall();
        call.setTargetEndpointAddress(new java.net.URL(endpoint));
        
        call.addParameter("name", org.apache.axis.encoding.XMLType.XSD_STRING,
                javax.xml.rpc.ParameterMode.IN);
        // 这句是要指定你传的参数名要跟他那边需要的参数名称一样
        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
        // 这句是指定你参数的类型
        call.setUseSOAPAction(true);
        //用到wsdl来进行parse才能正确转换，我就在后面添加了一行代码：
        call.setEncodingStyle(endpoint);
                
        StringBuffer buffer=new StringBuffer(5000);
        buffer.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
        .append(" <soap:Body><getDetailInfoByTrainCode xmlns=\"http://WebXml.com.cn/\"> <TrainCode>").append("T101")
        .append("</TrainCode><theUserID></theUserID></getDetailInfoByTrainCode> </soap:Body></soap:Envelope>");
       
        call.setOperationName("getDetailInfoByTrainCode");
        String res = (String) call.invoke(new Object[] { buffer.toString()});
        System.out.print(res);*/
    }
	
    /**
     * 获取经纬度 TODO 
     */
    public String LocateByAddress(String cityName,String addrName) throws Exception{
        
        URL url=new URL("http://webservice.36wu.com/mapService.asmx");
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        //因为服务端接受的是xml 格式的数据，那么我需要设置text/xml;charset=UTF-8
        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        //add
        //connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //要往服务端发送数据,接受数据...
        connection.setDoInput(true);
        connection.setDoOutput(true);
        //设置提交方式为post...
        connection.setRequestMethod("POST");
        OutputStream outputStream=connection.getOutputStream();
        StringBuffer buffer=new StringBuffer(5000);
        
        buffer.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
        .append(" <soap:Body><LocateByAddress xmlns=\"Yangzhili/\"><city>").append(cityName)
        .append("</city><addr>").append(addrName).append(" </addr>")
        .append("<UserId></UserId></LocateByAddress></soap:Body></soap:Envelope>");
        
        outputStream.write(buffer.toString().getBytes());
        outputStream.flush();
        
        Thread.sleep(1000);
        
        InputStream is=connection.getInputStream();
        byte [] b=new byte [1024];
        int length=0;
        StringBuffer sb=new StringBuffer();
        while((length=is.read(b))!=-1){
            String string=new String(b,0,length);
            sb.append(string);
        }
        return sb.toString();
    }
    
    
    public String getIdCardInfo(String idcard,String authkey) throws Exception{
        
        URL url=new URL("http://web.36wu.com/IdCardService.asmx");
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        //因为服务端接受的是xml 格式的数据，那么我需要设置text/xml;charset=UTF-8
        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        //add
        //connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //要往服务端发送数据,接受数据...
        connection.setDoInput(true);
        connection.setDoOutput(true);
        //设置提交方式为post...
        connection.setRequestMethod("POST");
        OutputStream outputStream=connection.getOutputStream();
        StringBuffer buffer=new StringBuffer(5000);
        
        buffer.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
        .append(" <soap:Body><GetIdCardInfo xmlns=\"http://www.36wu.com/\"><idcard>").append(idcard)
        .append("</idcard><authkey>")
        .append(authkey).append("</authkey>")
        .append("</GetIdCardInfo></soap:Body></soap:Envelope>");
        
        outputStream.write(buffer.toString().getBytes());
        outputStream.flush();
        
        Thread.sleep(1000);
        
        InputStream is=connection.getInputStream();
        byte [] b=new byte [1024];
        int length=0;
        StringBuffer sb=new StringBuffer();
        while((length=is.read(b))!=-1){
            String string=new String(b,0,length);
            sb.append(string);
        }
        return sb.toString();
    }
    
    
    public String getGeneralExpressInfo(String postid,String comName,String authkey) throws Exception{
        
        URL url=new URL("http://web.36wu.com/ExpressService.asmx");
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        //因为服务端接受的是xml 格式的数据，那么我需要设置text/xml;charset=UTF-8
        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        //add
        //connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //要往服务端发送数据,接受数据...
        connection.setDoInput(true);
        connection.setDoOutput(true);
        //设置提交方式为post...
        connection.setRequestMethod("POST");
        OutputStream outputStream=connection.getOutputStream();
        StringBuffer buffer=new StringBuffer(5000);
        
        buffer.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
        .append(" <soap:Body><GetGeneralExpressInfo xmlns=\"http://www.36wu.com/\"><postid>").append(postid)
        .append("</postid><com>").append(comName).append("</com><authkey>")
        .append(authkey).append("</authkey>")
        .append("</GetGeneralExpressInfo></soap:Body></soap:Envelope>");
        
        outputStream.write(buffer.toString().getBytes());
        outputStream.flush();
        
        Thread.sleep(1000);
        
        InputStream is=connection.getInputStream();
        byte [] b=new byte [1024];
        int length=0;
        StringBuffer sb=new StringBuffer();
        while((length=is.read(b))!=-1){
            String string=new String(b,0,length);
            sb.append(string);
        }
        return sb.toString();
    }
    
    
    public String getEnCnTwoWayTranslator(String translateWord) throws Exception{
        
        URL url=new URL("http://webservice.webxml.com.cn/WebServices/TranslatorWebService.asmx");
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        //因为服务端接受的是xml 格式的数据，那么我需要设置text/xml;charset=UTF-8
        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        //add
        //connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //要往服务端发送数据,接受数据...
        connection.setDoInput(true);
        connection.setDoOutput(true);
        //设置提交方式为post...
        connection.setRequestMethod("POST");
        OutputStream outputStream=connection.getOutputStream();
        StringBuffer buffer=new StringBuffer(5000);
        
        buffer.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
        .append(" <soap:Body><getEnCnTwoWayTranslator xmlns=\"http://WebXml.com.cn/\"><Word>").append(translateWord)
        .append("</Word><UserID></UserID></getEnCnTwoWayTranslator></soap:Body></soap:Envelope>");
        
        outputStream.write(buffer.toString().getBytes());
        outputStream.flush();
        
        Thread.sleep(1000);
        
        InputStream is=connection.getInputStream();
        byte [] b=new byte [1024];
        int length=0;
        StringBuffer sb=new StringBuffer();
        while((length=is.read(b))!=-1){
            String string=new String(b,0,length);
            sb.append(string);
        }
        return sb.toString();
    }
    
    
    public String getDetailInfoByTrainCode(String trainCode) throws Exception{
        
        URL url=new URL("http://webservice.webxml.com.cn/WebServices/TrainTimeWebService.asmx");
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        //因为服务端接受的是xml 格式的数据，那么我需要设置text/xml;charset=UTF-8
        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        //add
        //connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //要往服务端发送数据,接受数据...
        connection.setDoInput(true);
        connection.setDoOutput(true);
        //设置提交方式为post...
        connection.setRequestMethod("POST");
        OutputStream outputStream=connection.getOutputStream();
        StringBuffer buffer=new StringBuffer(5000);
        
        buffer.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
        .append(" <soap:Body><getDetailInfoByTrainCode xmlns=\"http://WebXml.com.cn/\"><TrainCode>").append(trainCode)
        .append("</TrainCode><UserID></UserID></getDetailInfoByTrainCode></soap:Body></soap:Envelope>");
        
        outputStream.write(buffer.toString().getBytes());
        outputStream.flush();
        
        Thread.sleep(1000);
        
        InputStream is=connection.getInputStream();
        byte [] b=new byte [1024];
        int length=0;
        StringBuffer sb=new StringBuffer();
        while((length=is.read(b))!=-1){
            String string=new String(b,0,length);
            sb.append(string);
        }
        return sb.toString();
    }
    
    
	public String getWeather(String cityName) throws Exception{
		
		URL url=new URL("http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx");
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		//因为服务端接受的是xml 格式的数据，那么我需要设置text/xml;charset=UTF-8
		connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
		//要往服务端发送数据,接受数据...
		connection.setDoInput(true);
		connection.setDoOutput(true);
		//设置提交方式为post...
		connection.setRequestMethod("POST");
		OutputStream outputStream=connection.getOutputStream();
		StringBuffer buffer=new StringBuffer(5000);

		buffer.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
		.append(" <soap:Body><getWeather xmlns=\"http://WebXml.com.cn/\"> <theCityCode>").append(cityName)
		.append("</theCityCode><theUserID></theUserID></getWeather> </soap:Body></soap:Envelope>");
		
		outputStream.write(buffer.toString().getBytes());
		InputStream is=connection.getInputStream();
		byte [] b=new byte [1024];
		int length=0;
		StringBuffer sb=new StringBuffer();
		while((length=is.read(b))!=-1){
			String string=new String(b,0,length);
			sb.append(string);
		}
		return sb.toString();
	}
	
	
	public String getRegionProvince() throws Exception{
	    
	    URL url=new URL("http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx");
	    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
	    //因为服务端接受的是xml 格式的数据，那么我需要设置text/xml;charset=UTF-8
	    connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
	    //要往服务端发送数据,接受数据...
	    connection.setDoInput(true);
	    connection.setDoOutput(true);
	    //设置提交方式为post...
	    connection.setRequestMethod("POST");
	    OutputStream outputStream=connection.getOutputStream();
	    StringBuffer buffer=new StringBuffer(5000);
	    
	    buffer.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
	    .append(" <soap:Body><getRegionProvince xmlns=\"http://WebXml.com.cn/\">")
	    .append("</getRegionProvince> </soap:Body></soap:Envelope>");
	    
	    outputStream.write(buffer.toString().getBytes());
	    InputStream is=connection.getInputStream();
	    byte [] b=new byte [1024];
	    int length=0;
	    StringBuffer sb=new StringBuffer();
	    while((length=is.read(b))!=-1){
	        String string=new String(b,0,length);
	        sb.append(string);
	    }
	    return sb.toString();
	}
	
	public String getAddressByZipCode(String zipCode) throws Exception{
	    
	    URL url=new URL("http://webservice.webxml.com.cn/WebServices/ChinaZipSearchWebService.asmx");
	    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
	    //因为服务端接受的是xml 格式的数据，那么我需要设置text/xml;charset=UTF-8
	    connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
	    //要往服务端发送数据,接受数据...
	    connection.setDoInput(true);
	    connection.setDoOutput(true);
	    //设置提交方式为post...
	    connection.setRequestMethod("POST");
	    OutputStream outputStream=connection.getOutputStream();
	    StringBuffer buffer=new StringBuffer(5000);
	    
	    buffer.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
	    .append("<soap:Body><getAddressByZipCode xmlns=\"http://WebXml.com.cn/\"><theZipCode>").append(zipCode)
	    .append("</theZipCode><userID></userID></getAddressByZipCode></soap:Body></soap:Envelope>");
	    
	    outputStream.write(buffer.toString().getBytes());
	    InputStream is=connection.getInputStream();
	    byte [] b=new byte [1024];
	    int length=0;
	    StringBuffer sb=new StringBuffer();
	    while((length=is.read(b))!=-1){
	        String string=new String(b,0,length);
	        sb.append(string);
	    }
	    return sb.toString();
	}
	
	
	public String getInfoByMobilePhone(String mobilePhoneNum) throws Exception{
	    
	    URL url=new URL("http://webservice.36wu.com/MobilePhoneService.asmx");
	    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
	    //因为服务端接受的是xml 格式的数据，那么我需要设置text/xml;charset=UTF-8
	    connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
	    //要往服务端发送数据,接受数据...
	    connection.setDoInput(true);
	    connection.setDoOutput(true);
	    //设置提交方式为post...
	    connection.setRequestMethod("POST");
	    OutputStream outputStream=connection.getOutputStream();
	    StringBuffer buffer=new StringBuffer(5000);
	    
	    //1.1版本
	   /* <soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	    <soap:Body>
	      <getInfoByMobilePhone xmlns="Yangzhili">
	        <PhoneNumber>string</PhoneNumber>
	        <UserId>string</UserId>
	      </getInfoByMobilePhone>
	    </soap:Body>
	  </soap:Envelope>*/
	    buffer.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
	    .append(" <soap:Body><getInfoByMobilePhone xmlns=\"http://webservice.36wu.com/Yangzhili/\"> <PhoneNumber>").append(mobilePhoneNum)
	    .append("</PhoneNumber><UserId></UserId></getInfoByMobilePhone> </soap:Body></soap:Envelope>");
	    
	    outputStream.write(buffer.toString().getBytes());
	    InputStream is=connection.getInputStream();
	    byte [] b=new byte [1024];
	    int length=0;
	    StringBuffer sb=new StringBuffer();
	    while((length=is.read(b))!=-1){
	        String string=new String(b,0,length);
	        sb.append(string);
	    }
	    return sb.toString();
	}
	
	
}
