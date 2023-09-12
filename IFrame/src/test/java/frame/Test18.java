package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test18
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver	driver=new ChromeDriver();
		//Launch site
		driver.get(
		 "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
		Thread.sleep(5000);
		//file upload
		driver.switchTo().frame("iframeResult"); //goto frame
		driver.findElement(By.id("myfile")).sendKeys(
				"C:\\Users\\Public\\Pictures\\Sample Pictures\\tulips.jpg");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent(); //back to page
		
	}
}



















