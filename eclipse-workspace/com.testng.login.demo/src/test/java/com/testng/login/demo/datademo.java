package com.testng.login.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datademo {
	
	@BeforeMethod
	public void launch()
	{
		BrowserUtility.launchBrowser("ch");
	}
	
	@Test(dataProvider="sample")
	public void validateLogin(String sUname, String sPwd) throws Exception {
		
		BrowserUtility.logintoBrowser(sUname, sPwd);
	
}

@DataProvider(name = "sample")
	public Object[][] validateUname(){
	return new Object[][] {{"admin123@gmail.com","admin123"}};
	
}


}
