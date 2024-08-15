package com.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Pages.LoginPage;
import com.qa.utils.ReadProperty;
import com.qa.ExcelManager.TestDataProvider;
import com.qa.Pages.ForgotPassPage;


public class LoginTest extends BaseTest {
	
	@DataProvider
	public Object[][] getLogineCredensials() throws Exception{
		Object[][] data = TestDataProvider.getTestData(ReadProperty.getProperty("SheetNameforDP"));
		return data;
	}
	
	@Test(dataProvider="getLogineCredensials",priority=1, groups="Smoke")
	public void verifyLoginTest(String Email, String Password) throws Exception{
		setTestDesc("Verify that Home Page is diaplyed when loged into CRM application");
		LoginPage l= new LoginPage();
		l.doLogin(Email, Password);
	}
	
	@Test(priority=0)
	public void verifyPageTitle(){
		setTestDesc("Verify the Title of Login Page");
		LoginPage l= new LoginPage();
		l.getPateTitle();
		Assert.assertEquals(l.getPateTitle(), getLocString("LoginTitle"));
	}
	
	@Test(priority=-2)
	public void verifyinvalidLoginLogout(){
		setTestDesc("Veify the taht when user try login with invalid credencials, error messg is displayed");
		LoginPage l= new LoginPage();
		l.verifyInvalid(getLocString("Email"), getLocString("Password"));
		Assert.assertTrue(l.VerifyIn());
		Assert.assertTrue(l.verifySomething());
	}
	
	@Test
	public void verifyForgotPass() throws InterruptedException{
		setTestDesc("Verify that Forgot Password page is displayed with email text box and Forgot text");
		LoginPage l= new LoginPage();
		ForgotPassPage fp = new ForgotPassPage();
		l.forgoPassowrd();
		Assert.assertTrue(fp.verifyEmail());
		Assert.assertTrue(fp.verifyForgot());
	}
	
	@Test
	public void verifyThatGoto() throws InterruptedException{
		setTestDesc("Verify that Login page is displayed when clicked on Go To Login Page from ForgotPage");
		LoginPage l= new LoginPage();
		ForgotPassPage fp = new ForgotPassPage();
		l.forgoPassowrd();
		fp.clickLoginHere();
		Assert.assertEquals(l.getPateTitle(), "abc");
		//Assert.assertEquals(l.getPateTitle(), getLocString("LoginTitle"));
	}

}
