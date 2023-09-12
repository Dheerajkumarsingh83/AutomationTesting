package WithoutPOM;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginWithoutPOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//open url
		driver.get("https://www.saucedemo.com/");
		
		//find & enter username
		driver.findElement(By.id("user-name")).sendKeys("problem_user");
		
		//find & enter password
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		//find & enter login
		driver.findElement(By.id("login-button")).click();
	}

}
