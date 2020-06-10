package com.testng.login.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {
	
	public static WebDriver driver = null;
	public static void launchBrowser(String sBrowser) {
		if(sBrowser.startsWith("ch")) {
		WebDriverManager.chromedriver().setup();
		//launch the Chrome browser
		driver = new ChromeDriver(); 
		}
		else if(sBrowser.startsWith("e"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		else
		{
			System.out.println("You have not given browser type correctly");
		}
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		}
	
	
	
	
	
	static void quitBrowser(){
		driver.quit();
		}
	static void logintoBrowser(String sUsername, String sPassword) throws Exception {
		
		//Selenium WebDriverWait is an Explicit Wait.
		//It is confined to particular WebElement.
		//It is applied to particular WebElement with ExpectedCondition and time.
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//wait until email field is visible
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys(sUsername);
		WebElement password =  driver.findElement(By.id("password_field"));
		password.sendKeys(sPassword);
		WebElement loginbutton = driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
		loginbutton.click();
		//Wait Until Switch To button is visible
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"))));
				}
	
	  static void waitForPageElementToBeVisible(WebElement ele) {
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.visibilityOf(ele));
	  }
	


}
