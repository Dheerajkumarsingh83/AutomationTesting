package mypack;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test195 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Create DevTools session 
		DevTools dt=driver.getDevTools();
		dt.createSession();
		//Set blocked URL patterns
		Command cmd1=Network.enable(Optional.empty(),Optional.empty(),Optional.empty());
		Command cmd2=Network.setBlockedURLs(ImmutableList.of("*.css","*.png","*.gif"));
		dt.send(cmd1);
		dt.send(cmd2);
		//Launch site
		driver.get("https://www.redbus.in");
		Thread.sleep(5000);
		//driver.close();
	}
}
