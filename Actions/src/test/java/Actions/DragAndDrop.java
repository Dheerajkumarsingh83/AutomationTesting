package Actions;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.WebElement;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.openqa.selenium.interactions.Actions;		
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;	
public class DragAndDrop {

    WebDriver driver;			

    @Test		
    public void DragnDrop() throws Exception					
    {		
    	WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();					
         driver.get("http://demo.guru99.com/test/drag_drop.html");					
         
		//Element which needs to drag.    		
        	WebElement e1=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
         Thread.sleep(5000);
         
         //Element on which need to drop.		
         WebElement e2=driver.findElement(By.xpath("//*[@id='bank']/li"));					
         Thread.sleep(5000);
         //Using Action class for drag and drop.		
         Actions act=new Actions(driver);					

	//Dragged and dropped.		
         act.dragAndDrop(e1, e2).build().perform();		
	}		
}
