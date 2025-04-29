package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadUtilProperties {

	public String readURL() throws IOException {
		
		
		String urrl = System.getProperty("user.dir")+"//src//test//resources//Util.properties";
		Properties p = new Properties();
		InputStream fis = new FileInputStream(urrl);
		p.load(fis);
	    String browserurl = p.get("url").toString();
		
		//System.out.println(browserurl);
		return browserurl;
		
	}
	
	public String readUsername() throws IOException {
		String urrl = System.getProperty("user.dir")+"//src//test//resources//Util.properties";
		Properties p = new Properties();
		InputStream fis = new FileInputStream(urrl);
		p.load(fis);
	    String username = p.get("username").toString();
		
		//System.out.println(browserurl);
		return username;
		
	}
	
	public String readPassword() throws IOException {
		String urrl = System.getProperty("user.dir")+"//src//test//resources//Util.properties";
		Properties p = new Properties();
		InputStream fis = new FileInputStream(urrl);
		p.load(fis);
	    String password = p.get("password").toString();
		
		//System.out.println(browserurl);
		return password;
		
	}
}
