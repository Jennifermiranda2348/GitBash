package com.hrm.genericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of java related methods
 * @author Jennifer
 */
public class JavaUtility {
	/**
	 * This method is used to get the random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
	/**
	 * This method is used to get system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date date = new Date();
		return date.toString();
	}
	/**
	 * This method is used to get date in the desired format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date dateTime = new Date();
		String[] d = dateTime.toString().split(" ");
		
		String day = d[0];
		String month = d[1];
		Object date = d[2];
		String year = d[3];
		
		String finalFormat = day+" "+month+" "+date+" "+year;
		return finalFormat;
	}
}
