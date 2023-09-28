package com.hrm.genericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenerClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//actual testscripts execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"------>Execution starts");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"------>Passed");
		Reporter.log(MethodName+"----- Testscript executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		try
		{
			String FailedScript = WebdriverUtility.takeScreenShot(BaseClass.sdriver,MethodName);
			test.addScreenCaptureFromPath(FailedScript);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL,result.getThrowable());
		test.log(Status.FAIL,MethodName+"-------Failed");
		Reporter.log(MethodName+"------> Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,result.getThrowable());
		test.log(Status.SKIP,MethodName+"-----> Skipped");
		Reporter.log(MethodName+"-----> Skipped");
				
	}

	@Override
	public void onStart(ITestContext context) {
		//Create HTML report
				ExtentSparkReporter htmlreport = new ExtentSparkReporter("./Extentreport/report.html");
				htmlreport.config().setDocumentTitle("HRM");
				htmlreport.config().setTheme(Theme.DARK);
				htmlreport.config().setReportName("HRM Report");
				
				report = new ExtentReports();
				report.attachReporter(htmlreport);
				report.setSystemInfo("OS","Windows-11");
				report.setSystemInfo("Base-Browser","chrome");
				report.setSystemInfo("Base-URL","http://rmgtestingserver/domain/HRM_System/");
				report.setSystemInfo("Reporter Name", "Jennifer");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	

}
