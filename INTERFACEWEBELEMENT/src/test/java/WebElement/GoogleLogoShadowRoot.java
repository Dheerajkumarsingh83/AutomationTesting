package WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLogoShadowRoot {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
       WebDriverManager.chromedriver().setup();

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open Google homepage
        driver.get("https://www.google.com/");

        // Find the Google logo element
        WebElement googleLogo = driver.findElement(By.className("lnXdpd"));

        // Extract the shadow root element of the Google logo
        WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", googleLogo);

        // Find the inner element within the shadow root
        WebElement innerElement = shadowRoot.findElement(By.tagName("a"));

        // Perform actions on the inner element within the shadow root
        System.out.println("Inner element text: " + innerElement.getText());

        // Close the browser
        driver.quit();
    }
}
