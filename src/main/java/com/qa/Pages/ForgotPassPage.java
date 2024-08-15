package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassPage extends BasePage {
	@FindBy(xpath="//h2[@class='ui blue header']")
	WebElement ForgotMy;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement EmailText;
	
	@FindBy(xpath="//button[normalize-space()='Reset password']")
	WebElement ResetButton;

	@FindBy(xpath="//a[normalize-space()='Got an account? Log in here']")
	WebElement LoginHere;
	
	public boolean verifyForgot(){
		return ForgotMy.isDisplayed();
	}
	
	public boolean verifyEmail(){
		return EmailText.isDisplayed();
	}
	
	public LoginPage clickLoginHere(){
		click(LoginHere);
		return new LoginPage();
	}
	
}
