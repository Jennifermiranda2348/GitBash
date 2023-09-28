package com.hrm.genericUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consists of methods to fetch common data from property file
 * @author Jennifer
 */
public class FileUtility {
public String getPropertyKeyValue(String key) throws Throwable
{
	FileInputStream fis = new FileInputStream(IPathconstants.propertiesFilePath);
	Properties pro = new Properties();
	pro.load(fis);
	return pro.getProperty(key);

}

}
