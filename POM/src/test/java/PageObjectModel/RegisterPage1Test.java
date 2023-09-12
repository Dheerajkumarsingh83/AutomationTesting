package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPage1Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// main class execute login page
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		//create objectof login page and add driver argument
		RegisterPage1 Regispg = new RegisterPage1(driver);
		//open url
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		Regispg.clickRegLink();
		Regispg.enterFirstName("Kush");
		Regispg.enterLastName1("website");
		Regispg.enterPhone("12345");
		Regispg.enterEmail("dheerajkumarsingh83@gmail.com");
		Regispg.enterAddress("dhanbad");
		Regispg.enterCity("chirkunda");
		Regispg.enterState("jharkhand");
		Regispg.enterPostalCode("1234");
		Regispg.enterCountry("india");
		Regispg.enterUserName("dheeraj");
		Regispg.enterPassword("12345");
		Regispg.enterConfirmPassword("12345");
		Regispg.enterFirstName("demo");
		Regispg.enterSubmit();
	}

}
