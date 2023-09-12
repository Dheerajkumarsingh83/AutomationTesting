package gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefs1 extends Base
{
	@Given("open browser")
	public void method1()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@When("launch site {string}")
	public void method2(String x)
	{
		driver.get(x);
	}
	
	@Then("page title should be {string}")
	public void method3(String x)
	{
		if(driver.getTitle().equals(x))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
	}
	
	@When("search {string} and click enter key")
	public void method4(String x)
	{
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
	}
}
