package project_BrokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink_AmazonApp {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","F:\\Selenium\\Chrome Versions\\Chrome Version 108\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(int i = 0; i<links.size(); i++) 
		{
			try 
			{
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			String linkText = element.getText();
			
			URL link = new URL(url);
			
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			int resCode = httpConn.getResponseCode();
			
			if(resCode>=400) 
			{
				System.out.println(linkText + " -- It is a broken link.");
			}
			else 
			{
				System.out.println(linkText + " -- It is a valid link.");
			}
			}
		catch(Throwable e) 
			{
			e.printStackTrace();
			}
		}
	}
}


