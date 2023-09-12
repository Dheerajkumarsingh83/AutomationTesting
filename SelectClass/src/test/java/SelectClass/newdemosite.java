package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newdemosite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	    String baseURL = "https://demo.automationtesting.in/Register.html";
	    WebDriver driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sharban");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("singh");
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("delhi");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		

		Select lang = new Select(driver.findElement(By.id("Skills")));
		lang.selectByVisibleText("Adobe InDesign");
		
         driver.findElement(By.xpath("//span[@role='combobox']"));
		driver.findElement(By.xpath("//span[@title='Japan']"));
	}

}
