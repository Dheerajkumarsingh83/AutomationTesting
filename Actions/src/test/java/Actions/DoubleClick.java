package Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;
public class DoubleClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();

	//Launch the Application Under Test (AUT)
	driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	driver.manage().window().maximize();

	//Double click the button to launch an alertbox
	Actions action = new Actions(driver);
	WebElement link =driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
	action.doubleClick(link).perform();
	//Switch to the alert box and click on OK button
	Alert alert = driver.switchTo().alert();
	System.out.println("Alert Text\n" +alert.getText());
	alert.accept();
	//Closing the driver instance
	//driver.quit();
	}

}
