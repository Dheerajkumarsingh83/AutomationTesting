

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test39
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(3000);
		//do login
		driver.findElement(By.name("identifier")).sendKeys("magnitiait");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("44@Magnitia");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(3000);
		//get and classify cookies
		Set<Cookie> s=driver.manage().getCookies();
		List<Cookie> l=new ArrayList<Cookie>(s);
		for(Cookie c:l)
		{
			if(c.isHttpOnly())
			{
				if(c.getName().equalsIgnoreCase("session-id") 
						                    || c.getName().contains("SID"))
				{
					System.out.println(c.getName()+" is HTTP-only Session cookie");
				}
				else if(c.getName().equalsIgnoreCase("session-id-time"))
				{
					System.out.println(c.getName()+
					" is HTTP-only Persistent cookie and it expires on "+c.getExpiry());
				}
				else
				{
					System.out.println(c.getName()+" is Pure Http-only cookie");     
				}
			}
			else if(c.isSecure())
			{
				if(c.getName().equalsIgnoreCase("session-id") 
	                    || c.getName().contains("SID"))
				{
					System.out.println(c.getName()+" is secure Session cookie");
				}
				else if(c.getName().equalsIgnoreCase("session-id-time"))
				{
					System.out.println(c.getName()+
					" is secure Persistent cookie and it expires on "+c.getExpiry());
				}
				else
				{
					System.out.println(c.getName()+" is Pure secure cookie");     
				}
			}
			else if(c.getDomain().contains("gmail.com"))
			{
				System.out.println(c.getName()+" is Same-site cookie");
			}
			else if(c.getDomain().contains("google.com")) 
			{
				System.out.println(c.getName()+" is Super cookie");
			}
			else
			{
				System.out.println(c.getName()+
						" is third-party cookie and its came from "+c.getDomain());
			}
		}
		//close site
		driver.close();
	}
}









