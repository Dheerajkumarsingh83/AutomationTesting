package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//using page factory
public class RegisterPage1 {

		//identity web element
		//identity user name
		@FindBy(how=How.LINK_TEXT,using="REGISTER")
		WebElement Reglink;
		
		@FindBy(how=How.NAME, using="firstName")
		WebElement FirstName;
		
		//@FindBy(name="firstName")
		//WebElement FirstName;
		
		@FindBy(name="lastName")
		WebElement LastName;
		
		@FindBy(name="phone")
		WebElement  phone;
		
		@FindBy(name="userName")
		WebElement Email;
		
		@FindBy(name="address1")
		WebElement Address;
		
		@FindBy(name="city")
		WebElement City;
		
		@FindBy(name="state")
		WebElement State;
		
		@FindBy(name="postalCode")
		WebElement PostalCode;
		
		@FindBy(name="country")
		WebElement Country ;
		
		@FindBy(name="email")
		WebElement  UserName;
		
		@FindBy(name="password")
		WebElement Password ;
		
		@FindBy(name="confirmPassword")
		WebElement ConfirmPassword;
		
		@FindBy(name="submit")
		WebElement Submit;
		

		//constructor
		WebDriver driver;
		RegisterPage1(WebDriver d)
		{
			driver = d;
			
			//this method will create web element
			PageFactory.initElements(driver, this);
		}
		public void enterFirstName(String fName)
		{
			FirstName.sendKeys(fName);
		}
		
		public void enterLastName1(String LName)
		{
			LastName.sendKeys(LName);
		}
		
		public void enterPhone(String ph)
		{
			phone.sendKeys(ph);
		}
		public void enterEmail(String email)
		{
			Email.sendKeys(email);
		}
		public void enterAddress(String address1)
		{
			Address.sendKeys(address1);
		}
		public void enterCity(String city)
		{
			City.sendKeys(city);
		}
		public void enterState(String state)
		{
			State.sendKeys(state);
		}
		public void enterPostalCode(String PCode)
		{
			PostalCode.sendKeys(PCode);
		}
		public void enterCountry (String country)
		{
			Country.sendKeys(country);
		}
		public void enterUserName(String email)
		{
			UserName.sendKeys(email);
		}
		public void enterPassword (String pass)
		{
			Password.sendKeys(pass);
		}
		
		public void enterConfirmPassword (String Cpass)
		{
			ConfirmPassword.sendKeys(Cpass);
		}
		public void enterSubmit ()
		{
			Submit.click();
		}
		public void clickRegLink() 
		{
			Reglink.click();
		}
		
	}
	 

