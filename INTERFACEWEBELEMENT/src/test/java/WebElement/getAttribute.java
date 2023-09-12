package WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getAttribute {
    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        String placeholderValue = searchBox.getAttribute("placeholder");
        String typevalue = searchBox.getAttribute("type");
        String autocompletevalue = searchBox.getAttribute("autocomplete");
        String spellcheckvalue = searchBox.getAttribute("spellcheck");
        String rolevalue = searchBox.getAttribute("role");
        String ariacontolsvalue = searchBox.getAttribute("aria-controls");
        String ariaexpandvalue = searchBox.getAttribute("aria-expanded");
        System.out.println("Placeholder value: " + placeholderValue);
        System.out.println("type value: " + typevalue);
        System.out.println(" autocomplete value: " + autocompletevalue);
        System.out.println(" spellcheck value: " + spellcheckvalue);
        System.out.println("role value: " + rolevalue);
        System.out.println(" ariacontols value: " + ariacontolsvalue);
        System.out.println(" ariaexpand value: " + ariaexpandvalue);

        driver.quit();
    }
}
