package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Test155
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")))
		                       .sendKeys("bse sensex",Keys.ENTER);
		//move to specific location of element
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(
		  By.xpath("((//*[text()='BSE SENSEX'])[2]/following::*[name()='svg']//*[name()='g'])[1]")));
		ActionsUtility au=new ActionsUtility(driver,wait);
		au.focusOnElementLocation(e,100,10);
	}
}





