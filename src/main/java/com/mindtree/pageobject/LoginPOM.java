package com.mindtree.pageobject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exception.PageObjectRException;
import com.mindtree.reusablecompanents.DriverFunctions;
import com.mindtree.uistore.LoginPageUI;
import com.mindtree.utility.ExtentUtility;
import com.mindtree.utility.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginPOM extends LoginPageUI {

	public LoginPOM(Logger logger, ExtentTest test, WebDriver driver, String username, String password) // for accessing
	// the login
	// page
	{

		try 
		{
			DriverFunctions.click(driver, login);
			Thread.sleep(2000);
			Log.testLoggerInfo(logger, "logging Page navigated");
			ExtentUtility.pass(test, "LoginPOM accessed");
		}

		catch (Exception e)
		{

			Log.testLoggerError(logger, "logging interrupted");
			ExtentUtility.fail(test, driver, "LoginPOM");
			// e.printStackTrace();
		}

		try {
			if (driver.getTitle().equals("Account– eLocalshop")) {
				DriverFunctions.sendkeys(driver, user, username);
				// driver.findElement(user).sendKeys(username);
				DriverFunctions.sendkeys(driver, pass, password);
				// driver.findElement(pass).sendKeys(password);
				driver.findElement(submit).click();
				driver.findElement(site_logo).click();
				ExtentUtility.pass(test, "Succesfully loged in");
			}
			else
			{
				throw new PageObjectRException("Not logged In");
			}

		} catch (PageObjectRException e) {
			// TODO: handle exception
			ExtentUtility.fail(test, driver, e.toString());
		}

	}

}

// For the popup
/*
 * if (driver.findElement(login_popup).isDisplayed()) {
 * System.out.println(driver.findElements(login_popup).size());
 * DriverFunctions.sendkeys(driver,login_popup_user,username); //
 * driver.findElement(login_popup_user).sendKeys(username);
 * DriverFunctions.sendkeys(driver,login_popup_pass,password);
 * //driver.findElement(login_popup_pass).sendKeys(password);
 * DriverFunctions.click(driver,login_popup_submit);
 * //driver.findElement(login_popup_submit).click();
 * 
 * } else
 */
