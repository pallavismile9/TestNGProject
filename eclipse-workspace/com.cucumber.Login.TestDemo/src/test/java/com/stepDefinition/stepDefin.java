package com.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefin {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	@Given("^Browser is launched$")
	public void browser_is_launched()  {
	    WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	    }

	@Given("^User is on the Login Page$")
	public void user_is_on_the_Login_Page(){
	   driver.get("https://qa-tekarch.firebaseapp.com/");
	}

	@When("^User enters username and password$")
	public void user_enters_username_and_password(){
		
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");
		WebElement password =  driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
	   
	}

	@Then("^User clicks LoginButton$")
	public void user_clicks_LoginButton(){
		WebElement loginbutton = driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
		loginbutton.click();
	  
	}

	@Then("^User is on homepage$")
	public void user_is_on_homepage(){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"))));
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "Student Registration Form");
	}


}
