package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By userName = By.xpath("//input[@id='user-name']");
	private By userPassword =  By.id("password");
	private By loginButton = By.id("login-button");
	
	public void enterUserName(String userID) {
		driver.findElement(userName).sendKeys(userID);
	}
	
public void enterUserPassword(String password) {
		driver.findElement(userPassword).sendKeys(password);
}

   public void ClickloginButton() {
	  
	driver.findElement(loginButton).click();
}
}
