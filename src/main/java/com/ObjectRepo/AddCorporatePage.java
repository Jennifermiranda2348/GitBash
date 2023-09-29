package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCorporatePage {
	@FindBy(xpath="//h3[@class='card-title']")
	private WebElement corpBtn1; 
	
	@FindBy(name="corporate_name")
	private WebElement CorpName;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement SaveBtn;
	
	public AddCorporatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCorpBtn1() {
		return corpBtn1;
	}

	public WebElement getCorpName() {
		return CorpName;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	public void AddCorpandSave(String CorpName1) 
	{
		CorpName.sendKeys(CorpName1);
		SaveBtn.click();
	}
	
}
