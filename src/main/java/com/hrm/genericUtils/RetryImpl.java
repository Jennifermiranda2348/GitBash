package com.hrm.genericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpl implements IRetryAnalyzer {
	
	int count = 0;
	int upperLimit = 3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<upperLimit)
		{
			count++;
			return true;
		}
		return false;
	}
	
}