package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Shared
{
	public RemoteWebDriver driver;
	public Scenario se;
	public int stepno;
	
	@Before
	public void method1(Scenario s) //before every scenario
	{
		this.se=s;
		se.log(s.getName()+" is started");
		stepno=1;
	}
	
	@BeforeStep
	public void method2(Scenario s) //before every step
	{
		se.log("Step-"+stepno+" is started");
	}
	
	@AfterStep
	public void method3(Scenario s) //after every step
	{
		se.log("Step-"+stepno+" is completed");
		stepno++;
	}
	
	@After
	public void method4(Scenario s) //after every scenario
	{
		se.log(s.getName()+" is "+s.getStatus().name());
	}
}
