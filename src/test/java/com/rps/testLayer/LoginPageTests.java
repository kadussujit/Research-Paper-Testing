package com.rps.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rps.testBase.TestBase;

public class LoginPageTests extends TestBase{
	
	private String username = "sujit";
	
	@Test
	public void validLoginTest() {
		loginPage.enterUsername(username);
		loginPage.enterPassword("sujit");
		loginPage.clickOnLoginButton();
		submsnPage.displayWelcomeUserMessage();
	}
	
	@Test
	public void invalidLoginTest() {
		loginPage.enterUsername(username);
		loginPage.enterPassword(util.generateAlphaNumericString(8));
		loginPage.clickOnLoginButton();
		loginPage.isErrorMessageDisplayed();
	}
	
	@Test
	public void loginPageURLValidation() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("login"), "login");
		
	}
	
	@Test
	public void loginPageUIValidation() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("login"), "login");
		
		loginPage.loginPageUITextValidation();
		loginPage.usernameInputboxPresenceValidation();
		loginPage.usernamePlaceholderValidation();
		loginPage.passwordInputboxPresenceValidation();
		loginPage.passwordPlaceholderValidation();
		loginPage.loginButtonPresenceValidation();
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(util.generateAlphaNumericString(9));
		loginPage.clickOnLoginButton();
		loginPage.isErrorMessageDisplayed();
		loginPage.clearUsername();
		loginPage.usernamePlaceholderValidation();
		loginPage.clearPassword();
		loginPage.passwordPlaceholderValidation();
	}

}