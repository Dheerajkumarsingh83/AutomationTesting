package mypack;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.performance.Performance;
import org.openqa.selenium.devtools.v104.performance.model.Metric;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test198 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Launch site
        driver.get("https://www.amazon.com");
        Thread.sleep(5000);
		//Create DevTools session
		DevTools dt=driver.getDevTools();
	    dt.createSession();
	    //Activate Performance Panel
	    Command cmd1=Performance.enable(Optional.empty());
	    dt.send(cmd1);
        List<Metric> ms=dt.send(Performance.getMetrics());
        for(Metric m:ms)
        {
        	System.out.println(m.getName()+"="+m.getValue());
        }
	}
}
