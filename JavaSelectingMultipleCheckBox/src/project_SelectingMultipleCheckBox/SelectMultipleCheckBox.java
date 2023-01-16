package project_SelectingMultipleCheckBox;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectMultipleCheckBox {

	public static void main(String[] args) throws InterruptedException 
	{
		
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
		
		WebElement moreBrands = driver.findElement(By.xpath("//div[@class='QvtND5 _2w_U27']/span"));
		moreBrands.click();
		
		List<WebElement> brandCheckBoxList = driver.findElements(By.xpath("//section[@class='_167Mu3 _2hbLCH']//div[@class='_2RTO7p']//div[@class='_3BBnX4']/div/div"));
		int brandCheckBox = brandCheckBoxList.size();
		System.out.println(brandCheckBox);
		
		for(int i = 0; i<brandCheckBoxList.size(); i++) 
		{
			WebElement singleBrand = brandCheckBoxList.get(i);
			String brandName = singleBrand.getText();
			System.out.println(i + " -- " + brandName);
		}
		
		for(int j = 0; j<brandCheckBoxList.size(); j++) 
		{
			WebElement singleBrand = brandCheckBoxList.get(j);
			if(brandCheckBoxList.get(14) == singleBrand || brandCheckBoxList.get(23) == singleBrand || brandCheckBoxList.get(30) == singleBrand) {
				singleBrand.click();
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
