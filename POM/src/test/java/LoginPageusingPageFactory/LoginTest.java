package LoginPageusingPageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// main class execute login page
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				
				//create objectof login page and add driver argument
				LoginPage loginpg = new LoginPage(driver);
				
				//open url
				driver.get("https://www.saucedemo.com/");
				loginpg.enterUsername("problem_user");
				loginpg.enterPassword("secret_sauce");
				loginpg.clickOnLoginBtn();
				driver.close();
	}

}
