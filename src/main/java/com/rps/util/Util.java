package com.rps.util;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.rps.testBase.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Util extends TestBase{
	
	private String ssPath = "./Screenshots/";
	
	public void takeScreenshot(String filename)
	{
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(ssPath+filename+".png");
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Add correct path");
		}
	}
	
	public void takeFullPageScreenshot(String filename) {

	    try {
	        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	        ImageIO.write(screenshot.getImage(), "PNG", new File(ssPath + filename + ".png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Add correct path");
	    }
	}
	
//	public void captureFullPageScreenshot(String filename){
//        // Capture the full-page screenshot
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        // Copy the screenshot to the destination file
//        File destFile = new File(ssPath+filename+".png");
//        try {
//			FileUtils.copyFile(srcFile, destFile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }

	/**
     * Generates a random string of the specified length.
     *
     * @param length The length of the random string to generate.
     * @return The generated random string.
     */
    public String generateRandomString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be greater than zero.");
        }

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }

        return randomString.toString();
    }
}