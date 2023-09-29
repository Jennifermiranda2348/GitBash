package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;


public class LoginPage extends WebDriverUtility {
	//declaration
	@FindBy(name="hr_email")
	private WebElement UserName;
	
	@FindBy (name="hr_password")
	private WebElement Password;
	
	@FindBy(id="hr_type")
	private WebElement UserType;
	
	
	@FindBy(name="login_hr")
	private WebElement LoginBtn;
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getUserType() {
		return UserType;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	//Business libraries
	public void loginToApp(String UN,String Pwd, String text, WebElement ele)
	{
		UserName.sendKeys(UN);
		Password.sendKeys(Pwd);
		selectDropDown(text, ele);
		LoginBtn.click();
	}
}
