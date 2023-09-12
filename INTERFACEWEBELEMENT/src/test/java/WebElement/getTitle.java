package WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class getTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set the path to the chromedriver executable
		WebDriverManager.chromedriver().setup();

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open Google homepage
        driver.get("https://www.google.com/");

        // Find the search box element by its name
        WebElement searchBox = driver.findElement(By.name("q"));

        // Enter the search query
        searchBox.sendKeys("Selenium WebDriver");

        // Submit the search by pressing Enter
        searchBox.sendKeys(Keys.ENTER);

        // Wait for the search results to load
        // You can use explicit or implicit waits here if needed

        // Print the search results page title
        System.out.println("Search results page title: " + driver.getTitle());

        // Close the browser
        driver.quit();
	}

}
