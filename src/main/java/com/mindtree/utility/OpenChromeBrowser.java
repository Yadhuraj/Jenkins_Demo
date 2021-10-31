package com.mindtree.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser  {
	
	

	public static WebDriver OpenChrome(WebDriver driver,ReadProrperty rp) {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + rp.readDriver());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(rp.readUrl());
		return driver;
	}
}
