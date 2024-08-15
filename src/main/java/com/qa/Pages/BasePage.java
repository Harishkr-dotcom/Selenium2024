package com.qa.Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.browser.DriverFactory;
import com.qa.utils.Constants;

public class BasePage {
	public static Logger log = LogManager.getLogger(BasePage.class);
	
	public BasePage(){
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	public static void expliciteWait(WebElement element){
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Waiting for visibility of "+element);
	}
	
	public static void click(WebElement element){
		element.click();
		log.info("Clicked on the "+element);
	}
	
	public static void sendkeys(WebElement element, String keysToSend){
		element.sendKeys(keysToSend);
		log.info("Entering "+keysToSend+" to "+element);
	}
	
	public static void moveToElement(WebElement element) {
		Actions actions= new Actions(DriverFactory.getDriver());
		actions.moveToElement(element).build().perform();
		log.info("Moved to the location of "+element);
	}
	
	public static boolean isdisplayed(WebElement element){
		element.isDisplayed();
		log.info("Element found"+element);
		return true;
	}

}
