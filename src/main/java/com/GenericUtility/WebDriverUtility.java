package com.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimizeBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	public void implicitlyWait(WebDriver driver,int duration)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	public void waitUntilUrlLoads(WebDriver driver,int duration,String expectedURL)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedURL));
	}
	
	public void waitUntilTitleLoads(WebDriver driver, int duration, String expectedTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	
	public void waitUntilElementToBeClickable(WebDriver driver, int duration,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void ignoreNoSuchElementException(WebDriver driver, int duration)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public void customWait(WebElement element) throws Throwable 
	{
		int count = 0;
		while(count<20)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(2000);
				count++;
			}
		}
	}
	
	public void selectDropDown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void selectDropDown(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void selectDropDown(String text, WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void mouseHoverElement(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dst).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	public void clickOnEnterKey(WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	public void moveByOffset(WebDriver driver, int x, int y)
	{
		Actions a = new Actions(driver);
		a.moveByOffset(x,y).click().perform();
	}
	
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to move the scroll bar
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBarAction(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")","");
	}
}
