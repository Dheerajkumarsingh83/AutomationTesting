package gluecode;

import org.openqa.selenium.OutputType;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs2
{
	Shared sh;
	public StepDefs2(Shared sh)
	{
		this.sh=sh;
	}
	@Then("page title contains {string}")
	public void method5(String x)
	{
		if(sh.driver.getTitle().contains(x))
		{
			sh.se.log("Test passed");
		}
		else
		{
			sh.se.log("Test failed");
			String data=sh.driver.getScreenshotAs(OutputType.BASE64);
			sh.se.attach(data,"image/png","Title test failed after search");
		}
	}
	
	@When("quit/close site")
	public void method6()
	{
		sh.driver.close();
	}
}
