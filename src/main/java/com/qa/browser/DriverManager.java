package com.qa.browser;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.qa.utils.ReadProperty;

public class DriverManager {

	public static Logger log = LogManager.getLogger(DriverManager.class);

	public static void lunchBrowser() {
		WebDriver driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(ReadProperty.getProperty("WaitTime")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(ReadProperty.getProperty("URL"));
		driver.manage().deleteAllCookies();
		log.info("Browser launched...!");
	}

}
