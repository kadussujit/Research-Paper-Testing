package com.rps.testBase;

import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.rps.pageLayer.LoginPage;
import com.rps.pageLayer.SubmissionPage;
import com.rps.util.JSONread;
import com.rps.util.Util;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static final Logger logger = LogManager.getLogger(TestBase.class);;
	
	public static LoginPage loginPage;
	public static SubmissionPage submsnPage;
	public static Util util;
	public static JSONread jsonRead;
	
	
	@BeforeClass
	public void start() {
		logger.info("Framework Execution Started");
	}
	
	@AfterClass
	public void stop() {
		logger.info("Framework Execution stopped");
	}
	
	@BeforeMethod
	public void setUp() {
		
		String br = "chrome";
		
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome Browser Launched");
		}
		else if(br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox Browser Launched");
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge Browser Launched");
		}
		else
		{
			System.out.println("Enter correct browser name");
		}
		
		driver.get("https://research-paper-frontend.vercel.app/");
		logger.info("Website Launched");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Implicitly wait provided");
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//---------------Page class objects-------------
		loginPage = new LoginPage();
		submsnPage = new SubmissionPage();
		util = new Util();
		jsonRead = new JSONread();
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("Browser closed.");
	}

}