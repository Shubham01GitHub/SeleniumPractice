package project_HandlingSlider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","F:\\Selenium\\Chrome Versions\\Chrome Version 108\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		
		WebElement btn_X = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		btn_X.click();
		
		WebElement txtBox_Search = driver.findElement(By.xpath("//input[@name='q']"));
		txtBox_Search.sendKeys("Mobiles", Keys.ENTER);
		
		WebElement leftSlider = driver.findElement(By.xpath("//div[@class='_31Kbhn _28DFQy']/div"));
		WebElement rightSlider = driver.findElement(By.xpath("//div[@class='_31Kbhn WC_zGJ']/div"));
		Actions act =  new Actions(driver);
		act.dragAndDropBy(leftSlider, 90, 0).perform();
		Thread.sleep(2000);
		act.dragAndDropBy(rightSlider, -90, 0).perform();
		
		WebElement min_DropDown = driver.findElement(By.xpath("//div[@class='_1YAKP4']/select"));
		String minValue = min_DropDown.getAttribute("value");
		System.out.println(minValue);
		
		WebElement max_DropDown = driver.findElement(By.xpath("//div[@class='_3uDYxP']/select"));
		String maxValue = max_DropDown.getAttribute("value");
		System.out.println(maxValue);
		
		Thread.sleep(2000);
		driver.quit();
	}

}
