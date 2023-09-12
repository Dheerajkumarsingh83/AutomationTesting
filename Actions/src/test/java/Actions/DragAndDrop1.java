package Actions;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.WebElement;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.openqa.selenium.interactions.Actions;		
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class DragAndDrop1 {

    WebDriver driver;			
    @Test		
    public void DragnDrop()					
    {		
         WebDriverManager.chromedriver().setup();				
         driver= new ChromeDriver();					
         driver.get("http://demo.guru99.com/test/drag_drop.html");					
     
	//Element(BANK) which need to drag.		
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));					
      
        //Using Action class for drag and drop.		
        Actions act=new Actions(driver);					
      
        //Drag and Drop by Offset.		
        act.dragAndDropBy(From,135, 40).build().perform();		
 }		
}
