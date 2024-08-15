package com.qa.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;
import lombok.With;

public class General {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.softwaretestingmaterial.com/selenium-4/");
		Actions ac = new Actions(driver);
		ac.doubleClick().perform();
		driver.findElement(with(By.tagName("scsdv"))).getText();

	}
}
