package com.rps.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rps.testBase.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// --------------------------------- WebElements --------------------
	//username input box
	@FindBy(xpath="//input[@id='username']")
	private WebElement username_input;
	
	//password input box
	@FindBy(xpath="//input[@id='password']")
	private WebElement password_input;
	
	//login button
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement login_button;
	
	// --------------------------------- Methods --------------------------
	
	public void enterUsername(String username) {
		username_input.sendKeys(username);
		logger.info("Entered username");
	}
	
	public void enterPassword(String password) {
		password_input.sendKeys(password);
		logger.info("Entered Password");
	}
	
	public void clickOnLoginButton() {
		login_button.click();
		logger.info("Clicked on login button");
	}

}