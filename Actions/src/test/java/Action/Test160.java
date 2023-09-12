package Action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Test160
{
	public static void main(String[] args) throws Exception
	{
		//Multi-select drop down developed using <select> tag
		//Open browser
		WebSiteUtility wsobj=new WebSiteUtility();
		RemoteWebDriver driver=wsobj.openBrowser("chrome");
		//Define wait
		FluentWait<RemoteWebDriver> wait=wsobj.defineWait(driver);
		//Launch site
		wsobj.launchSite(driver,"https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		//Automate <select> tag drop-down
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeResult"));
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(
				                                                     By.name("cars")));
		Select s=new Select(e);
		//Test case-1: is it multi-select or not?
		if(s.isMultiple())
		{
			System.out.println("Multi-select drop down");
		}
		else
		{
			System.out.println("Single-select drop down");
		}
		//Test case-2: get all items and display
		List<WebElement> l=s.getOptions();
		System.out.println("All items are:");
		System.out.println("---------------");
		for(WebElement i:l)
		{
			System.out.println(i.getText());
		}
		//Test case-3: select multiple items
		Actions act=new Actions(driver);
		act.keyDown(Keys.CONTROL)
		   .click(s.getOptions().get(3)).pause(3000)
		   .click(s.getOptions().get(1)).pause(3000)
		   .click(s.getOptions().get(0)).pause(3000)
		   .click(s.getOptions().get(2)).pause(3000)
		   .keyUp(Keys.CONTROL).build().perform();
		//Test case-4: 
		String x=s.getFirstSelectedOption().getText();
		System.out.println("First item in selected items:");
		System.out.println("----------------------------");
		System.out.println(x);
		//Test case-5: get all selected items
		List<WebElement> y=s.getAllSelectedOptions();
		System.out.println("All selected items:");
		System.out.println("-------------------");
		for(WebElement i:y)
		{
			System.out.println(i.getText());
		}
		//Test case-5: deselect items
		s.deselectByVisibleText("Audi");
		Thread.sleep(5000);
		s.deselectByIndex(1); //2nd item
		Thread.sleep(5000);
		s.deselectByValue("opel"); //value in source code
		Thread.sleep(5000);
		s.deselectAll();
		//close site
		//wsobj.closeSite(driver);
	}
}





