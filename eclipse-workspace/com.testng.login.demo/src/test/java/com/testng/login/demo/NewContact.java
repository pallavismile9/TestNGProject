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

public class NewContact extends BrowserUtilitySalesforce{

	
	@BeforeSuite
		public void launchBrowser() {
		BrowserUtilitySalesforce.launchBrowser("ch");
	
	}
	@Test(priority=1)
	public void loginBrowser() throws Exception {
		Thread.sleep(5000);
		BrowserUtilitySalesforce.loginToBrowser();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "";
		Assert.assertEquals("Homepage not dispalyed", expectedTitle, actualTitle);

	}
	
	@Test(priority=1,dependsOnMethods="loginBrowser")
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
		
	@Test(priority=2, dependsOnMethods="findContacts")
	public void clickNewContactButton() throws Exception {
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement newcontact = driver.findElement(By.xpath("//input[@name='new']"));
		boolean b_newcontact = newcontact.isEnabled();
		Assert.assertEquals(true, b_newcontact);
		js.executeScript("arguments[0].click()", newcontact);
	}
	
	@Test(priority=3,dependsOnMethods="clickNewContactButton" )
	public void enterDetails() {
		WebElement firstname=driver.findElement(By.xpath("//input[@id='name_firstcon2']"));
		boolean b_firstname = firstname.isDisplayed();
		Assert.assertEquals(true, b_firstname);
		firstname.clear();
		firstname.sendKeys("Pallavi");
		
		//lastname
		WebElement lastname=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		boolean b_lastname = lastname.isDisplayed();
		Assert.assertEquals(true, b_lastname);
		lastname.clear();
		lastname.sendKeys("PM");
	}
	
	@Test(priority=4, dependsOnMethods="enterDetails")
	public void clickSave() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		boolean b_save = save.isEnabled();
		Assert.assertEquals(true, b_save);
		js.executeScript("arguments[0].click()", save);
		
	}
	@AfterSuite
		public void tearDown() {
		BrowserUtilitySalesforce.quitBrowser();
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	