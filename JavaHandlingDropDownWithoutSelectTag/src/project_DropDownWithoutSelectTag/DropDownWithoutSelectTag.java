package project_DropDownWithoutSelectTag;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithoutSelectTag {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","F:\\Selenium\\Chrome Versions\\Chrome Version 108\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.airvistara.com/in/en");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		
		WebElement country_DropDown = driver.findElement(By.xpath("//button[@id='select-country-dropdown']"));
		country_DropDown.click();
		
		List<WebElement> drpDown_options =  driver.findElements(By.xpath("//li[@class='flagstrap-icon pointed-cursor']"));
		System.out.println(drpDown_options.size() + " Countries.");
		System.out.println("The countries as per index are as follows: ");
		for(int j = 0 ; j<drpDown_options.size() ; j++) 
		{
			WebElement print_option = drpDown_options.get(j);
			System.out.println(j + "=" + print_option.getText());
		}
		
		System.out.println();
		
		for(int i = 0 ; i<drpDown_options.size() ; i++) 
		{
			WebElement option = drpDown_options.get(i);
			
			if(option.equals(drpDown_options.get(9))) 
			{
				System.out.println(option.getText() + " option gets selected.");
				option.click();
			}
		}
		 
		Thread.sleep(3000);
		driver.quit();
	}

}
