package mypack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.security.Security;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test197 
{
	public static void main(String[] args) 
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Create DevTools session and activate Security panel
		DevTools dt=driver.getDevTools();
	    dt.createSession();
	    //set to ignore SSL certificate errors
	    Command cmd1=Security.enable();
	    Command cmd2=Security.setIgnoreCertificateErrors(true);
	    dt.send(cmd1);
	    dt.send(cmd2);
        //launch insecure web site
        driver.get("https://expired.badssl.com/");
	}
}
