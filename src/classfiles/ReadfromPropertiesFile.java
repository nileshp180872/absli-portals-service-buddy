package classfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadfromPropertiesFile {

	public static void main(String[] args) throws IOException {
	
		//define file path in Java class
		FileInputStream fi = new FileInputStream("E:\\ABSLI_SELENIUM\\SERVICE_BUDDY\\src\\propertyfiles\\MyPropertiesFile.Properties");
		
		// system.getproperty("user.dir") gives user directory path
		//FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\MyStorage\\MyPropertiesFile.Properties");
		//create properties object
		Properties storage = new Properties();
		
		//load the propertiesfile
		storage.load(fi);
		
		//using getproperty() you can read the properties of file 
		
		//get all urls
		System.out.println(storage.getProperty("adminURL"));
		System.out.println(storage.getProperty("ClientURL"));
		
			
		System.out.println("******************************");
		
		// get all browsers
		System.out.println(storage.getProperty("browser1"));
		System.out.println(storage.getProperty("browser2"));
		System.out.println(storage.getProperty("browser3"));
		System.out.println(storage.getProperty("browser4"));
		
		System.out.println("******************************");
		
		// get all xpaths
		System.out.println(storage.getProperty("UserEmail"));
		System.out.println(storage.getProperty("UserPS"));
		System.out.println(storage.getProperty("LoginBtn"));
		System.out.println(storage.getProperty("img"));
		System.out.println(storage.getProperty("LogoutBtn"));
		
		System.out.println("******************************");
		// get user name & password
		System.out.println(storage.getProperty("UserEmailVal"));
		System.out.println(storage.getProperty("UserPSVal"));
		
		/*
		if(storage.getProperty("mainbrowser").equalsIgnoreCase("ie")) {
			System.out.println("write Code to launch IE browser");
		} else if(storage.getProperty("mainbrowser").equalsIgnoreCase("Chrome")) {
			System.out.println("write Code to launch Chrome browser");
		} else if(storage.getProperty("mainbrowser").equalsIgnoreCase("FireFox")) {
			System.out.println("write Code to launch firefox browser");
		}*/
		
	}

}
