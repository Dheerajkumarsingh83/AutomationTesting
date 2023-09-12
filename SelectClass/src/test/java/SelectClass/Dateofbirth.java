package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dateofbirth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	    String baseURL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	    WebDriver driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email_create")).sendKeys("dheerajkumar2@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("dheeraj");
		driver.findElement(By.id("customer_lastname")).sendKeys("singh");
		driver.findElement(By.id("passwd")).sendKeys("Dheeraj83@");
		
		Select days = new Select(driver.findElement(By.name("days")));
		days.selectByIndex(4);

		//Selecting Items in a Multiple SELECT elements
		Select Month = new Select(driver.findElement(By.id("fruits")));
		Month .selectByVisibleText("August");
	
		Select Year = new Select(driver.findElement(By.id("years")));
		Year.selectByVisibleText("1994");
		//driver.close();
	}

}
