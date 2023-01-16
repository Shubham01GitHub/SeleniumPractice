package com.qa.TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	/*
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("--incognito");		
		
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setCapability(ChromeOptions.CAPABILITY,coptions);
		coptions.merge(dcap);
		
		WebDriver driver = new ChromeDriver(coptions);
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.quit();
	}	
	*/
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("--incognito");		
		
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setCapability(ChromeOptions.CAPABILITY,coptions);
		coptions.merge(dcap);
		
		driver = new ChromeDriver(coptions);
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}

}
