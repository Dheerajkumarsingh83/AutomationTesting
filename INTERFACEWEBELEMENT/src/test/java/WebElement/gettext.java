package WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 
 
public class gettext {
  	
  	WebDriver driver;
  	
  	@BeforeTest
  	public void setUp(){
  		WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver();
  	}
  	
  	@Test
  	public void headingText(){
        	driver.get("https://phptravels.com/demo/");
        	driver.manage().window().maximize();
        	String expectedHeading = "APPLICATION TEST DRIVE";
        	
        	//Storing the text of the heading in a string
        	String heading = driver.findElement(By.xpath("//div[@class='text']//h2")).getText();
        	if(expectedHeading.equalsIgnoreCase(heading))
              	System.out.println("The expected heading is same as actual heading --- "+heading);
        	else
              	System.out.println("The expected heading doesn't match the actual heading --- "+heading);
  	}
  	@AfterTest
  	public void tearDown(){
        	driver.quit();
  	}
}
