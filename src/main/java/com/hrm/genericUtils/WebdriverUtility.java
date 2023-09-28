package com.hrm.genericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Jennifer
 */
public class WebdriverUtility {
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to close the browser
	 * @param driver
	 */
	
	public void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	
	/**
	 * This method will wait until elements in the page gets loaded
	 * @param driver
	 * @param duration
	 */
	public void implicitWait(WebDriver driver, int duration)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * This method will wait until the url of the page gets loaded
	 * @param driver
	 * @param duration
	 * @param expectedUrl
	 */
	public void waitUntilUrlLoads(WebDriver driver, int duration, String expectedUrl)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}
	/**
	 * This method will wait until the title of the page gets loaded
	 * @param driver
	 * @param duration
	 * @param expectedUrl
	 */
	
	public void waitUntilTitleLoads(WebDriver driver,int duration, String expectedUrl)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedUrl));
	}
	/**
	 * This method will wait until the element of the page gets loaded
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver, int duration, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will ignore NoSuchElementException and continues the execution
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver, int duration)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method will wait until the element to be visible in the page
	 * @param element
	 * @throws Throwable 
	 */
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
	/**
	 * This method will select a dropdown element based on index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will select a dropdown element based on value
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will select a dropdown element based on visible text
	 * @param text
	 * @param element
	 */
	public void selectDropDown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method is used to mouseover on an element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	/**
	 * This method is used to right click on an element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method is used to click on enter button
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is used to press enter key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to release the key
	 * @param driver
	 * @throws Throwable
	 */
	public void enteRelease(WebDriver driver) throws Throwable
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
	/**
	 * This method is used to drag and drop element
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst);
	}
	/**
	 * This method is used to double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method is used to switch from one frame to another using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch from one frame to another using id
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 * This method is used to switch from one frame to another using webElement
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to accept alert popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void acceptAlertPopup(WebDriver driver, String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().equalsIgnoreCase(expectedMsg))
		{
			System.out.println("Alert message is verified");
		}
		else
		{
			System.out.println("Alert message is not verified");
		}
		alt.accept();
	}
	/**
	 * This method is used to accept alert popup 
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	/**
	 * This method is used to dismiss the alert popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void dismissAlertPopup(WebDriver driver, String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().equalsIgnoreCase(expectedMsg))
		{
			System.out.println("Alert message is verified");
		}
		else
		{
			System.out.println("Alert message is not verified");
		}
		alt.dismiss();
	}
	/**
	 * This method is used to switch from one window to another based on title
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchWindowBasedOnTitle(WebDriver driver,String expectedTitle)
	{
		Set<String> set = driver.getWindowHandles();
		for(String str:set)
		{
			driver.switchTo().window(str);
			String title = driver.getTitle();
			if(title.contains(expectedTitle))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to switch from one window to another based on url
	 * @param driver
	 * @param expectedUrl
	 */
	public void switchWindowBasedOnUrl(WebDriver driver, String expectedUrl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if(url.contains(expectedUrl))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to take screenshot whenever the test scripts getting failed
	 * @param driver
	 * @param screenShotName
	 * @return
	 */
	public static String takeScreenShot(WebDriver driver, String screenShotName)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./screenShots/"+screenShotName+".png";
		File dst = new File(path);
		try
		{
			FileUtils.copyFile(src,dst);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return path;
	}
	/**
	 * This method is used to scroll to particular element
	 * @param driver
	 * @param element
	 */
	public void scrollToParticularElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
}	