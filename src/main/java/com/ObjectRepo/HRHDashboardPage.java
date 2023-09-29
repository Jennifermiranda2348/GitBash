package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;


public class HRHDashboardPage {
	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();
	//Add admin
	
	@FindBy(xpath="//p[contains(text(),'ADMIN')]")
	private WebElement AdminLink;
	
	@FindBy(xpath="//p[.='Add Admin']")
	private WebElement AdminBtn;
	
	//Add corporate
	
	@FindBy(xpath="//i[@class='nav-icon fa fa-handshake']")
	private WebElement CorpLink;
	
	@FindBy(xpath="//p[.='Add Corporate']")
	private WebElement CorpBtn;
	
	//Add employee
	@FindBy(xpath="//p[contains(text(),'EMPLOYEE')]")
	private WebElement EmpLink;
	
	@FindBy(xpath="//p[.='Add Employee']")
	private WebElement EmpBtn;
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	private WebElement HRHeadIcon;
	
	@FindBy(xpath="//i[@class='fa fa-power-off']")
	private WebElement LogoutBtn;
	
	public HRHDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdminLink() {
		return AdminLink;
	}

	public WebElement getAdminBtn() {
		return AdminBtn;
	}

	public WebElement getCorpLink() {
		return CorpLink;
	}

	public WebElement getCorpBtn() {
		return CorpBtn;
	}

	public WebElement getEmpLink() {
		return EmpLink;
	}

	public WebElement getEmpBtn() {
		return EmpBtn;
	}

	public WebElement getHRHeadIcon() {
		return HRHeadIcon;
	}

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
	
	public void corporateLink()
	{
		CorpLink.click();
		CorpBtn.click();
	}
	
	public void adminLink()
	{
		AdminLink.click();
		AdminBtn.click();
	}
	
	public void empLink()
	{
		EmpLink.click();
		EmpBtn.click();
	}
	
	public void logout()
	{
		HRHeadIcon.click();
		LogoutBtn.click();
	}
}
