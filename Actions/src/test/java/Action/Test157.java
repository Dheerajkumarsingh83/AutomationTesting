package Action;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Test157
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebSiteUtility wsobj=new WebSiteUtility();
		RemoteWebDriver driver=wsobj.openBrowser("chrome");
		//Define wait
		FluentWait<RemoteWebDriver> wait=wsobj.defineWait(driver);
		//Launch site
		wsobj.launchSite(driver,"https://www.w3schools.com/css/css_tooltip.asp");
        ActionsUtility au=new ActionsUtility(driver,wait);
        WebElement e1=
        		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("BOOTSTRAP")));
		System.out.println(au.getStaticToolTipText(e1));
		WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(text(),'Top')]")));
		System.out.println(au.getDynamicToolTipText(e2));
		//close site
		driver.close();
	}
}





