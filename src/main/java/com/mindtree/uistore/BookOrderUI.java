package com.mindtree.uistore;

import org.openqa.selenium.By;

public class BookOrderUI {
	public static By searchbar = By.xpath("//*[@name='q']");
	public static By product = By.xpath("(//*[@class='productitem'])[1]");
	public static By quantity = By.cssSelector("select[id='product-quantity-select']");
	public static By addTocart = By.xpath("//button[@type='submit']//span[@class='atc-button--text']");
	public static By site_logo = By.cssSelector("[class='site-header-logo']");
	public static By popUp = By.xpath("(//button[@class='atc-banner--close'])[1]");
	public static By check = By.xpath("(//*[@name ='checkout'])[1]");
	public static By cart = By.xpath("(//div[@class='site-header-cart'])");
}
