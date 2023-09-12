package gluecode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class StepDefs3 extends Base
{
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
