package com.hrm.objectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAdminPage {
	@FindBy(xpath="//button[contains(text(),'Add Admin')]")
	private WebElement AdminBtn1;
	
	@FindBy(name="hr_companyid")
	private WebElement CompID;
	
	@FindBy(name="hr_firstname")
	private WebElement FirstName;
	
	@FindBy(name="hr_lastname")
	private WebElement LastName;
	
	@FindBy(name="hr_middlename")
	private WebElement MiddleName;
	
	@FindBy(name="hr_contactno")
	private WebElement HrContactNo;
	
	@FindBy(id="hr_type")
	private WebElement Position;
	
	@FindBy(name="hr_email")
	private WebElement EmailID;
	
	@FindBy(name="hr_password")
	private WebElement Password;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement SaveBtn;
	
	public AddAdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdminBtn1() {
		return AdminBtn1;
	}

	public WebElement getCompID() {
		return CompID;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getMiddleName() {
		return MiddleName;
	}

	public WebElement getHrContactNo() {
		return HrContactNo;
	}

	public WebElement getPosition() {
		return Position;
	}

	public WebElement getEmailID() {
		return EmailID;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	public void clickOnAdmin()
	{
		AdminBtn1.click();
	}
	
	public void toAddAdminDetails(WebDriver driver,HashMap<String, String> map)
	{
		for(Entry<String, String> s:map.entrySet())
		{
		driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		
	}
	

}
