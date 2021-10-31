package com.mindtree.runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.pageobject.LoginPOM;
import com.mindtree.pageobject.TitleCheck;
import com.mindtree.pageobject.BookOrderPOM;
import com.mindtree.reusablecompanents.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ElocalStore_Runner extends BaseClass {
	public static Logger logger;
	public static ExtentTest extentTest;
	public static ExtentReports extent;
	
	@BeforeTest
	void set()
	{
	driver = DriverSetUp();
	}
	
	@Test (priority = 1)
	void titleCheck()
	{	logger = Logger.getLogger(ElocalStore_Runner.class.getName());
		extent = new ExtentReports(System.getProperty("user.dir")+"\\extentreport\\"+date+"_ExtendReport.html",false);
		extentTest= extent.startTest("titleCheck");	
		new TitleCheck(logger,driver,extentTest);
	}
	
	@Test(dataProvider = "data_values", priority = 2)
	void Login(String user,String pass) throws InterruptedException
	{
		extentTest= extent.startTest("test_login_valid");	
		new LoginPOM(logger,extentTest,driver,user,pass);
		Thread.sleep(2000);
	
		
	}	
	
	@Test(priority = 3)
	void bookOrder() throws IOException, InterruptedException
	{extentTest= extent.startTest("bookOrder");	
		new BookOrderPOM(driver).orderbook(logger,extentTest);
	}
	
	@DataProvider
	Object[][] data_values()
	{
		Object[][] obj = new Object[1][2];
		obj[0][0]="sedifek613@otozuz.com";
		obj[0][1] ="book@123";
//		obj[1][0]="sedifek@otozuz.com";
//		obj[1][1] ="book@1";
		return obj;
	}
	@AfterMethod
	void meth() {
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report

	}
	
	@AfterTest
	void end() throws InterruptedException
	{Thread.sleep(3000);
	extent.flush();
	extent.close();
		driver.close();
	}

}
