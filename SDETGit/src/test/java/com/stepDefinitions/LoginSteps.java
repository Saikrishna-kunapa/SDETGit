package com.stepDefinitions;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps {
	
private	WebDriver driver;
private LoginPage login;


@Before

public void setupBrowser() {
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 
}

	@Given("user is on login page")
	public void user_is_on_login_page() {
	   
	    driver.get("https://www.saucedemo.com/v1/");
	  
	}

	@When("user enters valid {string} and {string}")
	public void user_enters_valid_user_id_and_password(String userID, String password) {
	 
//	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userID);
//	  driver.findElement(By.id("password")).sendKeys(password);
		login = new LoginPage(driver);
		login.enterUserName(userID);
		login.enterUserPassword(password);
	  
	}

	@And("click on login button")
	public void click_on_login_button()  {
	    // Write code here that turns the phrase above into concrete actions
		//driver.findElement(By.id("login-button")).click();
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
			
		login.ClickloginButton();
		
	}

	@Then("verify use entered into home page")
	public void verify_use_entered_into_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	  String expected = "https://www.saucedemo.com/v1/inventory.html";
	  
	  String actual = driver.getCurrentUrl();
	  
	  Assert.assertEquals(actual, expected, "title mismatch");
	}

	@And("close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		if(driver != null) {
			driver.quit();	
		}
	}
@After
	
	public void close() {
		
	if(driver != null) {
		driver.quit();	
	}
	
	}
}

