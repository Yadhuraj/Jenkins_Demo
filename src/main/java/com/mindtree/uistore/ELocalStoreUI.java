package com.mindtree.uistore;

import org.openqa.selenium.By;

public class ELocalStoreUI {
	public By searchbar = By.xpath("//*[@name='q']");
	public static By product = By.xpath("(//*[@class='productitem'])[1]");
	public static By quantity = By.cssSelector("select[id='product-quantity-select']");
	public static By addTocart = By.xpath("//button[@type='submit']//span[@class='atc-button--text']");
	public static By site_logo = By.cssSelector("[class='site-header-logo']");
	public static By popUp = By.xpath("(//button[@class='atc-banner--close'])[1]");
	public static By check = By.xpath("(//*[@name ='checkout'])[1]");
	public static By cart = By.xpath("(//div[@class='site-header-cart'])");
	public static By giftshopCollections = By.xpath("//div[@id='shopify-section-162322998751ba8977']//a[@href='/collections/gifts-1']");
	
	
	
	public static By captach_iframe = By.cssSelector("[title='reCAPTCHA']");
	public static By captcha_presence = By.xpath("//div[@class='rc-anchor-content']");
	public static By capthca_checkbox = By.xpath("//div[@class='recaptcha-checkbox-border']");
	public static By captcha_submit = By.xpath("//input[@value='Submit']");
	public static By login_check = By.xpath("(//*[contains(text(),'My Account')])[1]");
}
