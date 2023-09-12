package mypack;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test200 
{
	public static void main(String[] args) throws Exception
	{
		//open browser 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Create DevTools session and set latitude and longitude values of desired location
		DevTools dt=driver.getDevTools();
		dt.createSession();
		HashMap<String,Object> params=new HashMap<String,Object>();
        params.put("latitude",27.1751);
        params.put("longitude",78.0421); 
        params.put("accuracy", 1);
        driver.executeCdpCommand("Emulation.setGeolocationOverride",params);
        //Launch site
		driver.get("http://www.google.com");
		
		
		
	}
}
