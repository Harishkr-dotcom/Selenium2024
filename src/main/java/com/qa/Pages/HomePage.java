package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	@FindBy(xpath="//span[@class='user-display']")
	WebElement username;
	
	@FindBy(xpath="//a[contains(text(),'Free account')]")
	WebElement freeaccount;

	@FindBy(xpath="//i[@class='trash alternate outline icon']")
	WebElement deleteIcon;
	
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement Calender;
	
	public boolean username(){
		return username.isDisplayed();
	}
	
	public void clickonCalender(){
		click(Calender);
	}
	
}
