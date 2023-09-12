package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test17
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver	driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.id("identifierId")).sendKeys("xxxxx");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("xxxxxx");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		//handle security alert window if exists
		try
		{
			driver.switchTo().frame("callout"); //goto frame
			driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent(); //back to page
		}
		catch(Exception ex)
		{
			System.out.println("No Security Alert window");
		}
		//compose mail
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@role='combobox']"))
		                            .sendKeys("xxxxxx@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("wishes");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']"))
		      .sendKeys("hi sis,\nhow are you?\nplease give respect to teachers\nbye");
		//file upload(1. locate type="file" element 2. use sendKeys() method)
		driver.findElement(By.name("Filedata")).sendKeys("E:\\Model Resume Exp.doc");
		Thread.sleep(5000); //wait during file upload
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		Thread.sleep(5000);
		//get output message
		String x=driver.findElement(By.xpath("(//div[@role='alert']//span)[2]"))
				                                                       .getText();
		System.out.println(x);
		//Do logout
		driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]"))
		                                                                      .click();
		Thread.sleep(5000);
		driver.switchTo().frame("account");
		driver.findElement(By.xpath("//div[text()='Sign out']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}



















