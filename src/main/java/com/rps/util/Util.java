package com.rps.util;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.rps.testBase.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Util extends TestBase {

	private String ssPath = "./Screenshots/";
	private Actions actions;

	public void takeScreenshot(String filename) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(ssPath + filename + ".png");
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Add correct path");
		}
	}

	public void takeFullPageScreenshot(String filename) {

		try {
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(ssPath + filename + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Add correct path");
		}
	}

	/**
	 * Generates a random string of the specified length.
	 *
	 * @param length The length of the random string to generate.
	 * @return The generated random string.
	 */
	public String generateAlphaNumericString(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("Length should be greater than zero.");
		}

		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder alphaNumericString = new StringBuilder();

		SecureRandom random = new SecureRandom();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			alphaNumericString.append(characters.charAt(randomIndex));
		}

		return alphaNumericString.toString();
	}

	public void selectOptionByVisibleText(WebElement dropdownElement, String visibleText) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(visibleText);
	}

	public void selectOptionByValue(WebElement dropdownElement, String value) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue(value);
	}

	public void selectOptionByIndex(WebElement dropdownElement, int index) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByIndex(index);
	}

	public void clickOnRadioButton(WebElement element) {

		// Check if the radio button is not already selected before clicking
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        // Perform drag-and-drop
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
    }
}