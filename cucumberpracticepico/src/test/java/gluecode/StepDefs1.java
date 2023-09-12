package gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefs1
{
	Shared sh;
	public StepDefs1(Shared sh)
	{
		this.sh=sh;
	}
	@Given("open browser")
	public void method1()
	{
		WebDriverManager.chromedriver().setup();
		sh.driver=new ChromeDriver();
	}
	
	@When("launch site {string}")
	public void method2(String x)
	{
		sh.driver.get(x);
	}
	
	@Then("page title should be {string}")
	public void method3(String x)
	{
		if(sh.driver.getTitle().equals(x))
		{
			sh.se.log("Test passed");
		}
		else
		{
			sh.se.log("Test failed");
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.se.attach(b,"image/png","Title test failed");
			//Hard Assertion(to stop further steps execution in current scenario)
			Assert.assertTrue(false); 
		}
	}
	
	@When("search {string} and click enter key")
	public void method4(String x)
	{
		sh.driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
	}
}
