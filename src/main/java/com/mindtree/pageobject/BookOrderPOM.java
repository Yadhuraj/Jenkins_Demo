package com.mindtree.pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.exception.PageObjectRException;
import com.mindtree.reusablecompanents.BaseClass;
import com.mindtree.reusablecompanents.DriverFunctions;
import com.mindtree.uistore.BookOrderUI;
import com.mindtree.utility.ExcelSheet;
import com.mindtree.utility.ExtentUtility;
import com.mindtree.utility.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class BookOrderPOM extends BookOrderUI {

	static WebDriver driver;
	BaseClass b;

	public BookOrderPOM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		// b = new BaseClass();
	}

	public static void orderbook(Logger logger,ExtentTest test) throws IOException, InterruptedException {
		try {
			for (int i = 0; i < BaseClass.sheet.getPhysicalNumberOfRows(); i++) {

				DriverFunctions.sendkeys(driver, searchbar, ExcelSheet.Excelread(i, 0));
				DriverFunctions.sendkeys(driver, searchbar, Keys.ENTER);
				DriverFunctions.click(driver, product);
				Select dropdown = new Select(driver.findElement(quantity));
				dropdown.selectByValue(ExcelSheet.Excelread(i, 1));
				DriverFunctions.click(driver, addTocart);
				// bop.addTocart().click();
				Thread.sleep(5000);
				if (driver.findElements(popUp).size() > 0) 
				{
					System.out.println(driver.findElements(popUp).size());
					driver.findElements(popUp).get(0).click();
				}
				DriverFunctions.click(driver, site_logo);
			}
			Log.testLoggerInfo(logger, "The Values are accesed from the Excel sheet");
			ExtentUtility.pass(test,  "The Values are accesed from the Excel sheet");
			
		} catch (Exception e) {
			Log.testLoggerError(logger, "The Values accesess from the Excel sheet is interrupted");
			ExtentUtility.fail(test, driver, "Values from Excel interrupted");
		}

		Thread.sleep(2000);
		DriverFunctions.click(driver, cart);
		try {
		if (driver.findElement(check).isDisplayed()) {
			System.out.println("Sucess");
			Log.testLoggerInfo(logger, "Successfully added to the cart");
			ExtentUtility.pass(test,  "Successfully added to the cart");
			}
		else
		{
			throw new PageObjectRException("Not added to the cart");
		}}
		catch (PageObjectRException e) {
			Log.testLoggerError(logger, "Not added to the cart");
			ExtentUtility.fail(test, driver, "Not added to the cart");
		}

	}
}
