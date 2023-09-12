package Fluentwait;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDrawings
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.groupboard.com/demo/groupboard-online-whiteboard-demo.shtml");
		//Clear existing drawings if exist
		FluentWait<ChromeDriver> w=new FluentWait<ChromeDriver>(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(1000));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(
													"//button[text()='Got It!']"))).click();
		Thread.sleep(10000); //extra waiting before cleaning
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		w.until(ExpectedConditions.elementToBeClickable(By.id("trash"))).click();
		w.until(ExpectedConditions.alertIsPresent()).accept();
		Point headorigin=new Point(450,250);
		Point leftEyeorigin=headorigin.moveBy(-50,-50);
		Point rightEyeorigin=headorigin.moveBy(50,-50);
		Point mouthorigin=headorigin.moveBy(0, 50);
		drawCircle(driver,headorigin,150,60,"full");
		drawCircle(driver,leftEyeorigin, 20, 20,"uphalf");
		drawCircle(driver,rightEyeorigin, 20, 20,"full");
		drawCircle(driver,mouthorigin,40, 30,"uphalf");
		Thread.sleep(5000);
		//Clear finished drawings
		w.until(ExpectedConditions.elementToBeClickable(By.id("trash"))).click();
		w.until(ExpectedConditions.alertIsPresent()).accept();
		Thread.sleep(5000);
	    //Close site
		driver.switchTo().defaultContent();
	  	driver.close();
	}
	
	public static void drawCircle(ChromeDriver driver, Point origin, double radius, 
			                                               int steps, String style) 
	{
	    Point firstPoint;
	    PointerInput pi=new PointerInput(PointerInput.Kind.MOUSE,"mouse");
	    Sequence circle=new Sequence(pi,0); //initial count is 0
	    int sp;
	    int ep;
	    if(style.equals("downhalf"))
	    {
	    	firstPoint=new Point((int)(origin.x+radius),origin.y);
	    	sp=1;
	    	ep=steps/2;
	    }
	    else if(style.equals("uphalf"))
	    {
	    	firstPoint=new Point((int)(origin.x-radius),origin.y);
	    	sp=steps/2;
	    	ep=steps;
	    }
	    else //full
	    {
	    	firstPoint=new Point((int)(origin.x+radius),origin.y);
	    	sp=1;
	    	ep=steps;
	    }
	    //1.move to first point
	    Interaction a1=pi.createPointerMove(Duration.ofMillis(20),
                                            PointerInput.Origin.viewport(),
                                            firstPoint.x,
                                            firstPoint.y);
	    circle.addAction(a1);
	    //2. click and hold mouse left button
	    Interaction a2=pi.createPointerDown(PointerInput.MouseButton.LEFT.asArg());
	    circle.addAction(a2);
	    //3. move to various points via a loop
	    for(int i=sp; i<=ep; i++) 
	    {
	    	double theta=2*Math.PI*((double)i/steps);
		    int xoffset=(int)Math.floor(Math.cos(theta)*radius);
		    int yoffset=(int)Math.floor(Math.sin(theta)*radius);
		    Point nextpoint=new Point(origin.x + xoffset,origin.y + yoffset);
		    Interaction a3=pi.createPointerMove(Duration.ofMillis(50),
                    							PointerInput.Origin.viewport(), 
                    							nextpoint.x, 
                    							nextpoint.y);
	        circle.addAction(a3);
	    }
	    //4. release mouse left button
	    Interaction a4=pi.createPointerUp(PointerInput.MouseButton.LEFT.asArg());
	    circle.addAction(a4);
	    //Perform all defined actions
	    driver.perform(Arrays.asList(circle));
	}
}
