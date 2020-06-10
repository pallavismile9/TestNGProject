package com.testng.login.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilitySalesforce {
	public static WebDriver driver = null;
	public static void launchBrowser(String sBrowser){
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		
		}
	
	
	
	public static void loginToBrowser() throws Exception{
		
		WebElement loginScreen = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(loginScreen));
		loginScreen.click();
		
		String sPath=System.getProperty("user.dir")+ "\\Browserdata.properties";
		Properties prop=new Properties();
		FileInputStream fi = new FileInputStream(sPath);
		prop.load(fi);
		System.getProperties().putAll(prop);
		System.getProperty("username");
		System.getProperty("password");
		
		
		 
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		webElementToBeVisibile(username);
		username.sendKeys(System.getProperty("username"));
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		webElementToBeVisibile(password);
		password.sendKeys(System.getProperty("password"));
	
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		webElementToBeVisibile(login);
		login.click();
		
		}
	
	static void webElementToBeVisibile(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	static void webElementToBeClickable(WebElement elem) {
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(elem));
	}
	
	static void quitBrowser(){
		driver.quit();
		}
	
}
