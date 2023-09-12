package workeAutomationPackage;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkeRegistrstion
{

	public static void main(String[] args) throws Exception
	{
		ChromeDriver driver=null;
		WebDriverWait wait=null;
		String url = "https://dev.worke.io/register";
		String firstname = null;
		String lastname = null;
		String email= null;
		String phonenumber = null;
		String password = null;
		String business= null;
		String criteria= null;
		
		//To read data from Excel Sheet		
        File f=new File("src/test/resources/Worke_TestData.xlsx");
        FileInputStream fi=new FileInputStream(f);
        Workbook wb=WorkbookFactory.create(fi);
        Sheet sh=wb.getSheet("TestData");
        int usedrows= sh.getPhysicalNumberOfRows();
        int usedcols=sh.getRow(0).getPhysicalNumberOfCells();
        SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
        Date d=new Date();
        sh.getRow(0).createCell(usedcols).setCellValue("Result on "+sf.format(d));
        //Get data from Excel Sheet
        for(int i=1;i<usedrows;i++)
		{
			firstname = sh.getRow(i).getCell(0).getStringCellValue();
			lastname = sh.getRow(i).getCell(1).getStringCellValue();
			email = sh.getRow(i).getCell(2).getStringCellValue();
			phonenumber = sh.getRow(i).getCell(3).getStringCellValue();
			password = sh.getRow(i).getCell(4).getStringCellValue();
			business = sh.getRow(i).getCell(5).getStringCellValue();
			criteria = sh.getRow(i).getCell(6).getStringCellValue();
			// To Launch Chrome Browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// To Launch given site
			driver.get(url);

			// To fill valid data in the fields
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
			driver.findElement(By.id("first_name")).sendKeys(firstname);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name")));
			driver.findElement(By.id("last_name")).sendKeys(lastname);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("useremail")));
			driver.findElement(By.id("useremail")).sendKeys(email);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_number")));
			driver.findElement(By.id("phone_number")).sendKeys(phonenumber);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userpassword")));
			driver.findElement(By.id("userpassword")).sendKeys(password);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Business Name']")));
			driver.findElement(By.xpath("//*[@placeholder='Business Name']")).sendKeys(business);

			// to click Register button
			WebElement regbtn = driver.findElement(By.xpath("//*[text()='Register']"));
			wait.until(ExpectedConditions.elementToBeClickable(regbtn));
			driver.executeScript("arguments[0].click();", regbtn);
			if(criteria.equalsIgnoreCase("all_valid"))
            {
            	try
            	{
            		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Signin now')]")));
            		sh.getRow(i).createCell(usedcols).setCellValue("After successful Registration user navigates to sign in page");
            	}
            	catch(Exception ex)
            	{
            		sh.getRow(i).createCell(usedcols).setCellValue("Registration failed");
            		File src=driver.getScreenshotAs(OutputType.FILE);
            		File dest=new File("target/RegFail.png");
            	    FileHandler.copy(src, dest);
            	}
            }
            
            else if(criteria.equalsIgnoreCase("email_duplicate"))
            {
            	try
            	{
            		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='alertdialog']")));
            		sh.getRow(i).createCell(usedcols).setCellValue("Email Duplicate Test passed");
            	}
            	catch(Exception ex)
            	{
            		sh.getRow(i).createCell(usedcols).setCellValue("No alert present related to duplicate Email");
            		File src=driver.getScreenshotAs(OutputType.FILE);
            		File dest=new File("target/EmailDupFail.png");
            	    FileHandler.copy(src, dest);
            	}
            		
            }
            
            else if(criteria.equalsIgnoreCase("business_duplicate"))
            {
            	try
            	{
            		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
            		sh.getRow(i).createCell(usedcols).setCellValue("Business Duplicate Test passed");
            	}
            	catch(Exception ex)
            	{
            		sh.getRow(i).createCell(usedcols).setCellValue("No alert present related to duplicate Business Domain");
            		File src=driver.getScreenshotAs(OutputType.FILE);
            		File dest=new File("target/BusinessDupFail.png");
            	    FileHandler.copy(src, dest);
            	}
            }
            
            else if(criteria.equalsIgnoreCase("random_phno"))
            {
            	try
            	{
            		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='alertdialog']")));
            		sh.getRow(i).createCell(usedcols).setCellValue("Random Phone Number Test passed");
            	}
            	catch(Exception ex)
            	{
            		sh.getRow(i).createCell(usedcols).setCellValue("No alert present related to wrong Phone Number");
            		File src=driver.getScreenshotAs(OutputType.FILE);
            		File dest=new File("target/PhoneNumFail.png");
            	    FileHandler.copy(src, dest);
            	}
            }
            
            	
			// To close the browser
			driver.close();
			
		}
        FileOutputStream fo= new FileOutputStream(f);
		wb.write(fo);//Save
		fo.close();
		fi.close();
		wb.close();
	}

}
