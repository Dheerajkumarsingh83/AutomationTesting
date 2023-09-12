package mypack;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test196 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Connect to DevTools and change current time zone to other
		DevTools dt=driver.getDevTools();
		dt.createSession();
		Command cmd1=Network.enable(Optional.empty(),Optional.empty(),Optional.empty());
		Command cmd2=new Command("Emulation.setTimezoneOverride",
				                                ImmutableMap.of("timezoneId","GMT+11"));
		dt.send(cmd1);
		dt.send(cmd2);
        //Launch site
        driver.get("https://momentjs.com/");
        Thread.sleep(5000);
        
	}
}
