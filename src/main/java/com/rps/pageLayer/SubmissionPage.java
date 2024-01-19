package com.rps.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rps.testBase.TestBase;

public class SubmissionPage extends TestBase{
	
	public SubmissionPage()
	{
		PageFactory.initElements(driver, this);
	}

	// --------------------------------- WebElements --------------------
	
	@FindBy(xpath="//*[@class='text-slate-900 mt-5']")
	private WebElement welcome_user_message;
	
	// --------------------------------- Methods --------------------------
	
	public boolean displayWelcomeUserMessage() {
		return welcome_user_message.isDisplayed();
	}

}