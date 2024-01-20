package com.rps.pageLayer;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.rps.testBase.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// --------------------------------- WebElements --------------------
	/**
	 * Represents the username input box on the web page.
	 */
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username_input;

	/**
	 * Represents the password input box on the web page.
	 */
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password_input;

	/**
	 * Represents the login button on the web page.
	 */
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement login_button;

	/**
	 * Represents the login text on the web page.
	 */
	@FindBy(xpath = "//*[contains(text(),'Login')]")
	private WebElement login_text;

	/**
	 * Represents the username text on the web page.
	 */
	@FindBy(xpath = "//label[contains(text(),'Username')]")
	private WebElement username_text;

	/**
	 * Represents the password text on the web page.
	 */
	@FindBy(xpath = "//label[contains(text(),'Password')]")
	private WebElement passoword_text;

	/**
	 * Represents the login error message on the web page.
	 */
	@FindBy(xpath = "//*[@class='flex justify-center m-4']")
	private WebElement login_error_msg;

	// --------------------------------- Methods --------------------------

	/**
	 * This method is used to input the username in username input box
	 * 
	 * @author sujit.kadus
	 * @param username
	 */
	public void enterUsername(String username) {
		logger.info("Entering username " + username);
		username_input.sendKeys(username);
		logger.info("Entered username successfully...!");
	}

	/**
	 * This method is used to input the password in password input box
	 * 
	 * @author sujit.kadus
	 * @param password
	 */
	public void enterPassword(String password) {
		logger.info("Entering password " + password);
		password_input.sendKeys(password);
		logger.info("Entered Password successfully...!");
	}

	/**
	 * This method is used to click on Login button on login page
	 * 
	 * @author sujit.kadus
	 */
	public void clickOnLoginButton() {
		logger.info("Clicking on Login Button");
		login_button.click();
		logger.info("Clicked on login button...!");
	}

	/**
	 * This method is used to login in to the application
	 * 
	 * @author sujit.kadus
	 * @param username
	 * @param Password
	 */
	public void loginToApplication(String username, String Password) {
		enterUsername(username);
		enterPassword(Password);
		clickOnLoginButton();
		assert !isErrorMessageDisplayed() : "Login error message is displayed.";
	}

	/**
	 * Checks whether the login error message is displayed on the web page.
	 *
	 * @return {@code true} if the login error message is displayed, {@code false}
	 *         otherwise.
	 * 
	 *         This method attempts to locate the login error message element and
	 *         checks its visibility. If the element is found and displayed, it
	 *         returns {@code true}. If the element is not found, is stale, or times
	 *         out, it considers the message as not displayed and returns
	 *         {@code false}.
	 *
	 * @throws NoSuchElementException         if the login error message element is
	 *                                        not found.
	 * @throws StaleElementReferenceException if the login error message element
	 *                                        reference is stale.
	 * @throws TimeoutException               if the login error message element is
	 *                                        not visible within the specified
	 *                                        timeout.
	 * 
	 * @author sujit.kadus
	 */
	public boolean isErrorMessageDisplayed() {
		try {
			return login_error_msg.isDisplayed();
		} catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
			// If the element is not found or stale or times out, consider it as not
			// displayed
			return false;
		}
	}

	/**
	 * Validates the presence of login button
	 */
	public void loginButtonPresenceValidation() {
		Assert.assertTrue(login_button.isDisplayed());
	}

	/**
	 * Validates the presence of username input box
	 */
	public void usernameInputboxPresenceValidation() {
		Assert.assertTrue(username_input.isDisplayed());
	}

	/**
	 * Validates the presence of password input box
	 */
	public void passwordInputboxPresenceValidation() {
		Assert.assertTrue(password_input.isDisplayed());
	}

	public void loginPageUITextValidation() {
		Assert.assertTrue(login_text.isDisplayed());
		String login_uiText_actualText = login_text.getText();
		Assert.assertEquals(login_uiText_actualText, "Login");
		
		Assert.assertTrue(username_text.isDisplayed());
		String username_uiText_actualText = username_text.getText();
		Assert.assertEquals(username_uiText_actualText, "Username");
		
		Assert.assertTrue(passoword_text.isDisplayed());
		String password_uiText_actualText = passoword_text.getText();
		Assert.assertEquals(password_uiText_actualText, "Password");
		
		Assert.assertTrue(login_button.isDisplayed());
		String login_button_actualText = login_button.getText();
		Assert.assertEquals(login_button_actualText, "Login");
	}

	/**
	 * Validates the placeholder value for the username input field.
	 *
	 * @throws AssertionError if the placeholder value does not match the expected
	 *                        value.
	 * @author sujit.kadus
	 */
	public void usernamePlaceholderValidation() {
		logger.info("Validating username placeholder");
		String placeholderValue = username_input.getAttribute("placeholder");
		Assert.assertEquals(placeholderValue, "Enter your username");
		logger.info("Validated username placeholder...!");
	}

	/**
	 * Validates the placeholder value for the password input field.
	 *
	 * @throws AssertionError if the placeholder value does not match the expected
	 *                        value.
	 * @author sujit.kadus
	 */
	public void passwordPlaceholderValidation() {
		logger.info("Validating password placeholder");
		String placeholderValue = password_input.getAttribute("placeholder");
		Assert.assertEquals(placeholderValue, "Enter your password");
		logger.info("Validated password placeholder...!");
	}
	
	public void clearUsername() {
		logger.info("Clearing username field");
		username_input.clear();
		logger.info("Cleared username field...!");
	}
	
	public void clearPassword() {
		logger.info("Clearing password field");
		password_input.clear();
		logger.info("Cleared password field...!");
	}

	
}