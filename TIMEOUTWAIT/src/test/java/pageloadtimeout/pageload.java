package pageloadtimeout;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pageload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open browser
				WebDriverManager.chromedriver().setup();
				RemoteWebDriver	driver=new ChromeDriver();
				Duration d=driver.manage().timeouts().getPageLoadTimeout();
		        System.out.println(d.getSeconds());
				//Launch site
		        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
				driver.get("https://www.gmail.com");
		        //close site
		        driver.close();
	}

}
