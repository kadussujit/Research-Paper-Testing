package com.rps.testLayer;

import org.testng.annotations.Test;

import com.rps.testBase.TestBase;

public class LoginPage extends TestBase{
	
	private String username = "sujit";
	
	@Test
	public void LoginTest() throws InterruptedException {
		loginPage.enterUsername(username);
		loginPage.enterPassword("sujit");
		loginPage.clickOnLoginButton();
		submsnPage.displayWelcomeUserMessage();
		util.takeScreenshot("loginPageTestSuccess");
	}
	
	@Test
	public void LoginPageUITest() {
		
	}

}