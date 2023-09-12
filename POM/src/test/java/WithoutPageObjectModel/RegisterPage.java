package WithoutPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
WebDriver driver;
	
	//constructor for Loginpage
     RegisterPage(WebDriver d)
	{
		driver = d;
	}
     
     By RegLink = By.linkText("REGISTER");
     By FirstName = By.name("firstName");
     By LastName  = By.name("lastName");
     By Phone = By.name("phone");
     By Email = By.name("userName");
     By Address = By.name("address1");
     By City = By.name("city");
     By State = By.name("state");
     By PostalCode = By.name("postalCode");
     By Country = By.name("country");
     By UserName = By.name("email");
     By Password = By.name("password");
     By ConfirmPassword = By.name("confirmPassword");
     By Submit = By.name("submit");
     
     public void clickRegLink()
     {
    	 driver.findElement(RegLink).click();
     }
     public void enterFirstName(String Fname)
     {
    	 driver.findElement(FirstName).sendKeys(Fname);
     }
     
     public void enterLastName(String Lname)
     {
    	 driver.findElement(LastName).sendKeys(Lname);
     }
     public void enterPhone(String Phone1)
     {
    	 driver.findElement(Phone).sendKeys(Phone1);
     }
     public void enterEmail(String Email1)
     {
    	 driver.findElement(Email).sendKeys(Email1);
     }
     public void enterAddress(String Adds)
     {
    	 driver.findElement(Address).sendKeys(Adds);
     }
     public void enterCity(String City1)
     {
    	 driver.findElement(City).sendKeys(City1);
     }
     public void enterState(String State1)
     {
    	 driver.findElement(State).sendKeys(State1);
     }
     public void enterPostalCode(String pin)
     {
    	 driver.findElement(PostalCode).sendKeys(pin);
     }
     public void enterCountry(String Co)
     {
    	 driver.findElement(Country).sendKeys(Co);
     }
     public void enterUserName(String Uname)
     {
    	 driver.findElement(UserName).sendKeys(Uname);
     }
     public void enterPassword(String Pass)
     {
    	 driver.findElement(Password).sendKeys(Pass);
     }
     public void enterConfirmPassword(String ConfirmPass)
     {
    	 driver.findElement(ConfirmPassword).sendKeys(ConfirmPass);
     }
     public void enterSubmit()
     {
    	 driver.findElement(Submit).click();;
     }
}

