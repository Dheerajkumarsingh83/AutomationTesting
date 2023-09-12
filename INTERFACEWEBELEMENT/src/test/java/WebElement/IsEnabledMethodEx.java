package WebElement;
import java.time.Duration;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsEnabledMethodEx {

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

	// Declare and initialize variable to store the expected title of the webpage. 
	     String expectedTitle = "Google"; 

	// Fetch title of the web page and save it using a variable actualTitle with data type string. 
	     String actualTitle = driver.getTitle(); 

	// Compare expected title of the page with actual title of the page and print the result. 
	   if(expectedTitle.equals(actualTitle)) 
	   { 
		   System.out.println("Verification Successful - Correct title is displayed on the home webpage."); 
	}
	   else
	   {
		   System.out.println("Verification Failed - Correct title is displayed on the home webpage."); 	   
	   }
	// Check that “Google Search box” is enabled or not. If Search box is enabled, it will return true.
	   WebElement searchBox = driver.findElement(By.xpath("//input[@name=’q’]"));

if(searchBox.isEnabled()) {
	System.out.println("Search box is enabled.Run:"  +searchBox.isEnabled());
}
else
{
	System.out.println("Search box is disabled.Run:"  +searchBox.isEnabled());
}
//Enter text in the “Google Search” box. 
WebElement sendText = driver.findElement(By.xpath("//input[@name=’q’]"));
 sendText.sendKeys("Selenium Tool");

//Check that “Google Search button” is enabled or not. 
 WebElement searchButton = driver.findElement(By.xpath("//input[@class='gnO89b']"));
 
if(searchButton.isEnabled()) {
	System.out.println("Search button is enabled.Return:"  +searchButton.isEnabled());
}
else {
	System.out.println("Search button is not enabled.Return:"  +searchButton.isEnabled() );
}
driver.close();
	}
}