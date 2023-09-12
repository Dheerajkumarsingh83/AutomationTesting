package Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FacebookMouseClickandKeywordEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl = "http://www.facebook.com/"; 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			.contextClick()
			.build();
			
		seriesOfActions.perform() ;

	}

}
