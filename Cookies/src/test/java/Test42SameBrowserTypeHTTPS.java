

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test42SameBrowserTypeHTTPS
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser(opens without history and cookies by default)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch GMAIL site and do login
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("magnitiait"); 
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("44@Magnitia");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		//take new window/tab in chrome and switch to newly created window or tab(index is 1)
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> swh=driver.getWindowHandles(); 
		List<String> lwh=new ArrayList<String>(swh); 
		driver.switchTo().window(lwh.get(1));
		//Launch GMAIL site by skipping login due to session cookies sharing
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		try
		{
			if(driver.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
			{
				System.out.print("Gmail Session cookie is working correctly");
			}
		}
		catch(Exception ex)
		{
			System.out.print("Gmail Session cookie is not working correctly");
		}
		//close all browser windows/tabs along with cookies and history
		driver.quit();
	}
}
