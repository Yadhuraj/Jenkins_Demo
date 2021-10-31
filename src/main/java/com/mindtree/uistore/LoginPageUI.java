package com.mindtree.uistore;

import org.openqa.selenium.By;

public class LoginPageUI {
	public static By login = By.xpath("(//*[@class='site-header-account-link'])[1]");
	public static By user = By.xpath("//input[@id ='customer_email']");
	public static By pass = By.xpath("//input[@id ='customer_password']");
	public static By submit = By.xpath("//button[contains(text(),'Sign in')]");
	public static By login_popup = By.xpath("(//*[@id='oxipopup_login'])");
	public static By login_popup_user = By.xpath("(//*[@id='oxipopup_login']//input[@label='Email'])");
	public static By login_popup_pass = By.xpath("(//*[@id='oxipopup_login']//input[@label='Password'])");
	public static By login_popup_submit = By.xpath("(//*[@id='oxipopup_login']//button)");
	public static By site_logo = By.cssSelector("[class='site-header-logo']");
}
