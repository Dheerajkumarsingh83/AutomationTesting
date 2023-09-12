package Fluentwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test153 
{
	public static void main(String[] args)
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		//Locate and operate elements
		FluentWait<ChromeDriver> w=new FluentWait<ChromeDriver>(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(1000));
		WebElement e=w.until(ExpectedConditions.elementToBeClickable(
				                  By.xpath("//div[contains(text(),'Top')]")));
		Actions act=new Actions(driver);
		//move to element and do click and hold operation
		act.moveToElement(e).pause(5000).clickAndHold(e).pause(5000).build().perform();
		//locate tool-tip element and get text of it
		WebElement tt=e.findElement(By.xpath("child::span"));
		String temp=tt.getText();
		System.out.println(temp);
		//release mouse pointer
		act.release(e).perform();
		//close browser window
		driver.close();
	}
}
