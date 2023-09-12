

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test41SameBrowserTypeHTTP
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser(opens without history and cookies by default)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site and do login
		driver.get("http://www.testyou.in/Login.aspx"); 
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//img[contains(@src,'google.png')])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("magnitiait"); 
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("44@Magnitia");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		//take new window/tab in chrome and switch to that new window/tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> swh=driver.getWindowHandles(); 
		List<String> lwh=new ArrayList<String>(swh); 
		driver.switchTo().window(lwh.get(1));
		//Launch same site by skipping login due to session cookie
		driver.get("http://www.testyou.in/Login.aspx");
		Thread.sleep(5000);
		try
		{
			if(driver.findElement(By.className("signout")).isDisplayed())
			{
				System.out.print("Session cookie is working correctly");
			}
		}
		catch(Exception ex)
		{
			System.out.print("Session cookie is not working correctly");
		}
		//close all browser windows/tabs
		//driver.quit();
	}
}
