package com.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getPropertyKeyAndValue(String key)throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.propertiesFilePath);
		Properties pro = new Properties();
		pro.load(fis);
		return pro.getProperty(key);
		
		
	}
}
