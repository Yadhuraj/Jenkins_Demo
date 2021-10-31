package com.mindtree.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.exception.PageObjectRException;
import com.mindtree.uistore.ELocalStoreUI;
import com.mindtree.utility.ExtentUtility;
import com.mindtree.utility.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TitleCheck extends ELocalStoreUI {

	public TitleCheck(Logger log, WebDriver driver,ExtentTest test) {
	
		try{
			if(driver.getTitle().equals("India's Best Online Store | Free Shipping | eLocalshop"))
		{
			Log.testLoggerInfo(log, " Navigated to the expected page");	
			
			test.log(LogStatus.PASS, "Navigated to the expected page");
		}
		else
		{
			throw new PageObjectRException("page not opened with expected titile");
		}
		}
		catch(PageObjectRException e){
			Log.testLoggerError(log, e.toString());	
			ExtentUtility.fail(test,driver,"TitleCheck");
//			test.log(LogStatus.FAIL, "Did not navigated to the expected page");
		}
		}
	}
