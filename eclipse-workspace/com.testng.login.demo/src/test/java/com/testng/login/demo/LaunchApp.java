package com.testng.login.demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LaunchApp extends BrowserUtilitySalesforce{
	
	@BeforeMethod
		public void launchBrowser() {
		BrowserUtilitySalesforce.launchBrowser("ch");
		
	}
	
	
	@Test(groups = "loginPage")
	public void loginBrowser() throws Exception {
		BrowserUtilitySalesforce.loginToBrowser();
		String actualTitle = driver.getTitle();
		String expectedTitle = "";
	
		Assert.assertEquals(expectedTitle, actualTitle);
		Assert.assertEquals("Homepage not dispalyed", expectedTitle, actualTitle);
	}
	
	
	/*@AfterMethod
	
	public void tearDown() {
		BrowserUtilitySalesforce.quitBrowser();
	}*/
	
}
