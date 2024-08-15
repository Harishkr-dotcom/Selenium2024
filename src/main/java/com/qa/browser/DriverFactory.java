package com.qa.browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.Pages.BasePage;
import com.qa.utils.ReadProperty;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static Logger log = LogManager.getLogger(DriverFactory.class);
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		if (webDriver.get() == null) {
			log.info("Driver object is null so creating webdriver object");
			String browser = ReadProperty.getProperty("Browser");
			switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				webDriver.set(new ChromeDriver());
				log.info("Set browser as chrome");
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				webDriver.set(new FirefoxDriver());
				log.info("Set browser as firefox");
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				webDriver.set(new InternetExplorerDriver());
				log.info("Set browser as IE");
				break;
			default:
				throw new IllegalArgumentException("Browser not supported");
			}
		}
		log.info("Set Webdriver");
		return webDriver.get();
	}

	public static void quitDriver() {
		if (webDriver.get() != null) {
			log.info("Quiking the executing by killing web driver object");
			webDriver.get().quit();
			webDriver.remove();
		}
	}

}
