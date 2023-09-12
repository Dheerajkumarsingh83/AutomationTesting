package Websiteutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Test156
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebSiteUtility wsobj=new WebSiteUtility();
		RemoteWebDriver driver=wsobj.openBrowser("chrome");
		//Define wait
		FluentWait<RemoteWebDriver> wait=wsobj.defineWait(driver);
		//Launch site
		wsobj.launchSite(driver,"https://jqueryui.com/droppable");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		WebElement e1=driver.findElement(By.id("draggable"));
		WebElement e2=driver.findElement(By.id("droppable"));
		ActionsUtility au=new ActionsUtility(driver,wait);
		au.dragDrop(driver, e1, e2);
		driver.switchTo().defaultContent();
	}
}





