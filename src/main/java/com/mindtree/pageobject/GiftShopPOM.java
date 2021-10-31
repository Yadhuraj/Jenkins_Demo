package com.mindtree.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.ELocalStoreUI;

public class GiftShopPOM extends ELocalStoreUI{
	static WebDriver driver;
//	By site_logo = By.cssSelector("[class='site-header-logo']");
//	By popUp = By.xpath("(//button[@class='atc-banner--close'])[1]");
	public GiftShopPOM(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement giftItem(String item)
	{
		return driver.findElement(By.xpath("(//ul[@class='productgrid--items products-per-row-4']//li//a[contains(@href,'"+item+"')])[1]"));
	}
	
	public WebElement giftshopCollections()
	{
		return driver.findElement(giftshopCollections);
	}

	
}


