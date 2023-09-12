package WebElement;
import java.time.Duration;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager; 


public class isDisplayedMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create an object of FirefoxDriver class. 
		WebDriverManager.chromedriver().setup();
	     WebDriver driver = new ChromeDriver(); 

	// Launch the Firefox browser and open URL. 
	     String URL = "https://www.google.com"; driver.get(URL); 

	// Maximize browser window. 
	     driver.manage().window().maximize(); 

	// Delay for specified amount of time to load page. 
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	     WebElement searchBox = driver.findElement(By.xpath("//*[@id='APjFqb']")); 
	     
	    if(searchBox.isDisplayed()) { 
	       System.out.println("Search box is visible. Return: " +searchBox.isDisplayed()); 
	    } 
	    else { 
	       System.out.println("Search box is not visible. Return: " +searchBox.isDisplayed()); 
	    } 
	// Check that "Google Search button" is displayed or not. 
	     WebElement searchButton = driver.findElement(By.xpath("//input[@class='gNO89b']")); 
	   
	    if(searchButton.isDisplayed()) { 
	       System.out.println("Search button is visible. Return: " +searchButton.isDisplayed()); 
	    } 
	   else { 
	      System.out.println("Search button is not visible. Return: " +searchButton.isDisplayed()); 
	    } 
	driver.close(); 
	}

}
