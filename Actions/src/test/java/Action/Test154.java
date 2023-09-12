package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class Test154
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebSiteUtility wsobj=new WebSiteUtility();
		RemoteWebDriver driver=wsobj.openBrowser("chrome");
		//Define wait
		FluentWait<RemoteWebDriver> wait=wsobj.defineWait(driver);
		//Launch site
		wsobj.launchSite(driver,"http://www.google.co.in");
		ActionsUtility au=new ActionsUtility(driver,wait);
		//move to element
		WebElement e1=driver.findElement(By.linkText("Images"));
		au.focusOnElementCenter(e1);
		//Right click on element
		WebElement e2=driver.findElement(By.name("q"));
		au.rightClickOnElement(e2);
		//Double click on element
		WebElement e3=driver.findElement(By.linkText("Gmail"));
		au.doubleClickOnElement(e3);
		//close site
		wsobj.closeSite(driver);
	}
}





