package videoRecording;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ScreenRecorderUtil2.startRecord("main");
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

driver.get("http://tutorialsninja.com/demo/");

driver.findElement(By.name("search")).sendKeys("iphone");

driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']")).click();

driver.close();
ScreenRecorderUtil2.stopRecord();

	}

}
