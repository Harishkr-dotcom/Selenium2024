package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.browser.DriverFactory;
import com.qa.Pages.ForgotPassPage;

public class LoginPage extends BasePage {
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement EmailText;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement PasswordW;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement Submit;
	
	@FindBy(xpath="//p[normalize-space()='Invalid login']")
	WebElement InvalidLogin;
	
	@FindBy(xpath="//div[@class='header']")
	WebElement Something;
	
	@FindBy(xpath="//a[normalize-space()='Forgot your password?']")
	WebElement ForgotPaasword;
	
	@FindBy(xpath="//span[text()='Calendar']")
	WebElement Calender;
	
	public HomePage doLogin(String Email, String Password){
		sendkeys(EmailText, Email);
		sendkeys(PasswordW, Password);
		click(Submit);
		return new HomePage();
	}
	
	public String getPateTitle(){
		return DriverFactory.getDriver().getTitle();
	}
	
	public void verifyInvalid(String Email, String Password){
		sendkeys(EmailText, Email);
		sendkeys(PasswordW, Password);
		click(Submit);
	}
	
	public boolean VerifyIn(){
		return InvalidLogin.isDisplayed();
	}
	
	public boolean verifySomething(){
		return Something.isDisplayed();
	}
	
	public ForgotPassPage forgoPassowrd(){
		click(ForgotPaasword);
		return new ForgotPassPage();
	}

}
