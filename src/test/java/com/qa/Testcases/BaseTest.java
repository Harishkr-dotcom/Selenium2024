package com.qa.Testcases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.ExcelManager.TestDataLoader;
import com.qa.browser.DriverFactory;
import com.qa.browser.DriverManager;
import com.qa.reports.ExtentFactory;
import com.qa.utils.Constants;
import com.qa.utils.ReadProperty;

public class BaseTest {
	public static ExtentTest test;
	public static Logger log = LogManager.getLogger(BaseTest.class);
	public String testDesc;

	@BeforeTest
	public void startExtendReport() {
		log.info("In Before Test and configuring Extent Report");
		ExtentFactory.createReporter();
	}

	@BeforeMethod
	public void setup(Method m) {
		test = ExtentFactory.extent.createTest(m.getName());
		log.info("launching the browser for executing tests");
		DriverManager.lunchBrowser();
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) throws IOException {
		log.info("Successfully completed Test case, so analysing the result");
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed is " + result.getName());
			test.log(Status.FAIL, "TestCase Description : " + getTestDesc());
			test.log(Status.FAIL, "Test failed with Exception : " + result.getThrowable());
			String screenshotPath = getScreenShot(result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
			test.log(Status.SKIP, "TestCase Description : " + getTestDesc());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed is " + result.getName());
			test.log(Status.PASS, "TestCase Description : " + getTestDesc());
		}
		log.info("Closing the browser instance");
		DriverFactory.quitDriver();
	}

	@AfterTest(alwaysRun = true)
	public void flushReport() {
		log.info("Flushing the results into Extent report");
		ExtentFactory.extent.flush();
	}
	
	public static String getScreenShot( String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/target/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}

	private String getTestDesc() {
		return this.testDesc;
	}

	protected void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}
	
	public static String getLocString(String Key){
		Hashtable<String, String> ht =TestDataLoader.getLocalizedData(Constants.TESTDATA_DIR, ReadProperty.getProperty("Sheetname"), ReadProperty.getProperty("Languagename"));
		String retvalue = ht.get(Key);
		return retvalue;
	}
}
