package gluecode;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs2 extends Base
{
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
}
