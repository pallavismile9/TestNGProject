package com.testng.login.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//TestNG is built for testing process
//Even if 1 testcase is failed, we can still continue with another test case.
public class LoginTest {
	
	@BeforeSuite
	public void dependencyTriggering(){
		BrowserUtility.launchBrowser("ch");
		
	}
	
	@BeforeMethod
	public void getURL() {
		BrowserUtility.driver.get("https://qa-tekarch.firebaseapp.com/");
	}
	
	@Test(dataProvider="sample")
	public void checkLoginSuccess_ValidCredentials(String sName, String sPwd) throws Exception{
		BrowserUtility.logintoBrowser(sName, sPwd);
		
	}
	
	/*@Test
	public void checkLoginSuccess_InvalidCredentials() throws Exception{
		BrowserUtility.logintoBrowser("admin123@gmail.com", "admin12");
		
	}*/
	
	@AfterMethod
	public void logout() {
		if(BrowserUtility.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed())
			{
			BrowserUtility.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			//wait.until(ExpectedConditions.visibilityOf(BrowserUtility.driver.findElement(By.id("email_field"))));
			/*WebElement email = BrowserUtility.driver.findElement(By.id("email_field"));
			BrowserUtility.waitForPageElementToBeVisible(email);
			email.clear();*/
			}
		
		
	}
	
	@DataProvider(name = "sample")
	public Object[][] validateUname(){
	return new Object[][] {{"admin123@gmail.com","admin123"},{"admin123@gmail.com","admin12"}, {"admin12@gmail.com","admin12"}};
	
}
	
	@AfterSuite
	public void tearDownDependency() {
		BrowserUtility.quitBrowser();
		
	}
	

}
