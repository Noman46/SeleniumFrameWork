package com.inetBanking.utilites;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	
	public static Properties readThePropertiesFile() {
		Properties properties = new Properties();
		InputStream input;
		try {
			if(System.getProperty("server").equals("POD")) {
				input = new FileInputStream("D:\\Selenium\\inetBankingV1\\src\\test\\java\\com\\inetBanking\\utilites\\application.properties");
				properties.load(input);
				System.out.print("+++==================="+System.getProperty("server"));
			}
			else if(System.getProperty("server").equals("DEV")){
				input = new FileInputStream("D:\\Selenium\\inetBankingV1\\src\\test\\java\\com\\inetBanking\\utilites\\applicationDev.properties");
				properties.load(input);
				System.out.print("+++==================="+System.getProperty("server"));
			}	
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return properties;	 
	}
}
