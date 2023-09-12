package frame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test34
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver	driver=new ChromeDriver();
		//define implicit wait at top of the code
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//Launch site
		driver.get("https://www.gmail.com");
		//Do login
		driver.findElement(By.id("identifierId")).sendKeys("magnitiait");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		driver.findElement(By.name("Passwd")).sendKeys("44@Magnitia");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		//handle security alert window if exists
		try
		{
			driver.switchTo().frame("callout"); //goto frame
			driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
			driver.switchTo().defaultContent(); //back to page
		}
		catch(Exception ex)
		{
			System.out.println("No Security Alert window");
		}
		//compose mail
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		driver.findElement(By.xpath("//input[@role='combobox']"))
		                            .sendKeys("magnitiait@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("wishes");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']"))
		      .sendKeys("hi sis,\nhow are you?\nplease give respect to teachers\nbye");
		//file upload(1. locate type="file" element 2. use sendKeys() method)
		driver.findElement(By.name("Filedata")).sendKeys("E:\\Model Resume Exp.doc");
		Thread.sleep(5000); //wait for file uploading
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		//get output message
		String x=driver.findElement(By.xpath("(//div[@role='alert']//span)[2]"))
				                                                       .getText();
		System.out.println(x);
		//Do logout
		driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]"))
		                                                                      .click();
		driver.switchTo().frame("account");
		driver.findElement(By.xpath("//div[text()='Sign out']")).click();
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}
//sometimes above code will fail, because implicitlyWit() method is not consistent.


















