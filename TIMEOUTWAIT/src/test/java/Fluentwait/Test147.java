package Fluentwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test147 
{
	public static void main(String[] args) throws Exception
	{
		//launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in");
		//title test
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500)); //interval time
		wait.withTimeout(Duration.ofSeconds(20)); //maximum wait time
		wait.until(visibilityOfElementLocated(By.name("q")))
		                                            .sendKeys("abdul kalam",Keys.ENTER);
		if(wait.until(titleContains("abdul kalam")))
		{
			System.out.println("Test passed for abdul kalam");
		}
		else
		{
			System.out.println("Test failed for abdul kalam");
		}
		//close site
		driver.close();
	}
}
