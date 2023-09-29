package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditEmployeePage {

	@FindBy(name="employee_companyid")
	private WebElement CompID;
	
	@FindBy(name="employee_firstname")
	private WebElement FirstName;
	
	@FindBy(name="employee_lastname")
	private WebElement LastName ;
	
	@FindBy(name="employee_middlename")
	private WebElement MidName ;
	
	@FindBy(name="branches_datefrom")
	private WebElement FromDate ;
	
	@FindBy(name="branches_recentdate")
	private WebElement RecentDate ;
	
	@FindBy(name="employee_department")
	private WebElement EmpDept ;
	
	@FindBy(name="employee_branches")
	private WebElement EmpBranch;
	
	@FindBy(name="employee_position")
	private WebElement Position;
	
	@FindBy(name="employee_contact")
	private WebElement Contact ;
	
	@FindBy(name="employee_sss")
	private WebElement SSS ;
	
	@FindBy(name="employee_tin")
	private WebElement Tin;
	
	@FindBy(name="employee_hdmf_pagibig")
	private WebElement EmpHP ;
	
	@FindBy(name="employee_gsis")
	private WebElement GSIS;
	
	private EditEmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
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

	public WebElement getMidName() {
		return MidName;
	}

	public WebElement getFromDate() {
		return FromDate;
	}

	public WebElement getRecentDate() {
		return RecentDate;
	}

	public WebElement getEmpDept() {
		return EmpDept;
	}

	public WebElement getEmpBranch() {
		return EmpBranch;
	}

	public WebElement getPosition() {
		return Position;
	}

	public WebElement getContact() {
		return Contact;
	}

	public WebElement getSSS() {
		return SSS;
	}

	public WebElement getTin() {
		return Tin;
	}

	public WebElement getEmpHP() {
		return EmpHP;
	}

	public WebElement getGSIS() {
		return GSIS;
	}
	
	
}
