package gluecode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefs 
{
	public RemoteWebDriver driver;
	
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
	
	@Then("page title contains {string}")
	public void method5(String x)
	{
		if(driver.getTitle().contains(x))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
	}
	
	@When("quit/close site")
	public void method6()
	{
		driver.close();
	}
	
	@Then("search a word and click enter key and check page title")
	public void method7(DataTable dt) throws Exception
	{
		List<String> words=dt.asList(); //data table has one column only
		//start looping from 2nd word because 1st word(index=0) is heading
		for(int i=1;i<words.size();i++)
		{
			driver.findElement(By.name("q")).sendKeys(words.get(i),Keys.ENTER);
			Thread.sleep(3000);
			if(driver.getTitle().contains(words.get(i)))
			{
				System.out.println("Test passed");
			}
			else
			{
				System.out.println("Test failed");
			}
			driver.navigate().back(); //for next word testing
			Thread.sleep(3000);
		}
	}
	
}
