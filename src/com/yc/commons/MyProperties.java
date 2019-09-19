package com.yc.commons;

import java.io.IOException;
import java.util.Properties;

public class MyProperties  extends Properties{

	private static MyProperties properties =null;
	
	public MyProperties() {
		try {
			load(MyProperties.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static MyProperties getInstance() {
		if(null==properties) {
			properties =new MyProperties();
			
		}
		return properties;
	}
}
