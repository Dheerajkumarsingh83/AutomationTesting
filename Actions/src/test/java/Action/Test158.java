package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Test158
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebSiteUtility wsobj=new WebSiteUtility();
		RemoteWebDriver driver=wsobj.openBrowser("chrome");
		//Define wait
		FluentWait<RemoteWebDriver> wait=wsobj.defineWait(driver);
		//Launch site
		wsobj.launchSite(driver,"https://jqueryui.com/slider");
		//Horizontal slider
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		WebElement e1=driver.findElement(By.id("slider"));
		ActionsUtility au=new ActionsUtility(driver,wait);
		Thread.sleep(5000);
		au.moveSlider(e1, 100, 0); //left to right
		Thread.sleep(5000);
		au.moveSlider(e1,-100, 0); //right to left
		driver.switchTo().defaultContent();
		//Vertical slider
		wait.until(ExpectedConditions.elementToBeClickable(
				                 By.linkText("Vertical slider"))).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(
				                                   By.id("slider-vertical")));
		Thread.sleep(5000);
		au.moveSlider(e2, 0, 100); //top to bottom
		Thread.sleep(5000);
		au.moveSlider(e2, 0, -100); //bottom to top
		driver.switchTo().defaultContent();
	}
}





