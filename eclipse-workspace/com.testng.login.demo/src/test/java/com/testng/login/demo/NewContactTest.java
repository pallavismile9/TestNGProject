package com.testng.login.demo;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewContactTest extends BrowserUtilitySalesforce{

	
	@BeforeSuite
		public void launchBrowser() {
		BrowserUtilitySalesforce.launchBrowser("ch");
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
	}
	@Test(priority=1,groups = "loginPage")
	public void loginBrowser() throws Exception {
		Thread.sleep(5000);
		BrowserUtilitySalesforce.loginToBrowser();
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		Assert.assertEquals("Homepage not dispalyed", expectedTitle, actualTitle);

	}
	
	@Test(priority=1,dependsOnMethods="loginBrowser", groups="Functional Test")
	public void findContacts() throws Exception {
		Thread.sleep(5000);
		List<WebElement> li=driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
		System.out.println(li.size());
		for(WebElement ele: li) {
			System.out.println(ele.getText());
			if(ele.getText().contains("Contacts")) {
				boolean b = ele.getText().contains("Contacts");
				Assert.assertEquals(true, b);
				ele.click();
				break;
				}}}
		
	@Test(priority=2, dependsOnMethods="findContacts", groups="Functional Test")
	public void clickNewContactButton() throws Exception {
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement newcontact = driver.findElement(By.xpath("//input[@name='new']"));
		//webElementToBeClickable(newcontact);
		boolean b_newcontact = newcontact.isEnabled();
		Assert.assertEquals(true, b_newcontact);
		js.executeScript("arguments[0].click()", newcontact);
	}
	
	@Test(priority=3,dependsOnMethods="clickNewContactButton", groups="Functional Test" )
	public void enterDetails() {
		WebElement firstname=driver.findElement(By.xpath("//input[@id='name_firstcon2']"));
		//webElementToBeVisibile(firstname);
		boolean b_firstname = firstname.isDisplayed();
		Assert.assertEquals(true, b_firstname);
		firstname.clear();
		firstname.sendKeys("Pallavi");
		
		//lastname
		WebElement lastname=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		//webElementToBeVisibile(lastname);
		boolean b_lastname = lastname.isDisplayed();
		Assert.assertEquals(true, b_lastname);
		lastname.clear();
		lastname.sendKeys("PM");
	}
	
	@Test(priority=4, dependsOnMethods="enterDetails",groups="Regression Test")
	public void clickSave() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		//webElementToBeClickable(save);
		boolean b_save = save.isEnabled();
		Assert.assertEquals(true, b_save);
		
		//js.executeScript("arguments[0].click()", save);
		 js.executeScript("arguments[0].click()", save);
		
	}
	@AfterSuite
		public void tearDown() {
		BrowserUtilitySalesforce.quitBrowser();
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	