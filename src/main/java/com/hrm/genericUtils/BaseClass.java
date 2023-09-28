package com.hrm.genericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	public DatabaseUtility dLib = new DatabaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebdriverUtility wLib = new WebdriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		// dLib.connectToDB();
		System.out.println("-----Connected to Database-----");
	}
	
	//@Parameters("BROWSER")
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable
	{
		String BROWSER = fLib.getPropertyKeyValue("Browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		sdriver = driver;
		wLib.maximizeTheBrowser(driver);
		System.out.println("Launching of browser is successful");
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
		System.out.println("-----Close the browser-----");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable
	{
		// dLib.closeDB();
		System.out.println("------Database is disconnected-----");
	}
}
