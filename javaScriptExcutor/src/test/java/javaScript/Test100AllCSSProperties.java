package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test100AllCSSProperties
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site(operation)
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		//Locate element
		WebElement e=driver.findElement(By.xpath("//button[text()='Forgot email?']"));
		//before right click
		String x1=(String) driver.executeScript(
				"var s='';" + 
				"var o=window.getComputedStyle(arguments[0]);" + 
				"for(var i=0; i<o.length; i++)" + 
				"{" + 
					"s=s+o[i]+':'+o.getPropertyValue(o[i])+',';"	+ 
				"}" + 
				"return(s);",e);
		System.out.println(x1);
		//right click
		Actions act=new Actions(driver);
		act.contextClick(e).perform();
		Thread.sleep(5000);
		//after right click
		String y1=(String) driver.executeScript(
				"var s='';" + 
				"var o=window.getComputedStyle(arguments[0]);" + 
				"for(var i=0; i<o.length; i++)" + 
				"{" + 
					"s=s+o[i]+':'+o.getPropertyValue(o[i])+',';"	+ 
				"}" + 
				"return(s);",e);
		System.out.println(y1);
		//close site
		driver.close();
	}
}
