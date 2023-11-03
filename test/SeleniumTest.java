package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    @Test
    public void searchSeleniumTest() {
        boolean isDetected = false;
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");
        searchBox.submit();
        List<WebElement> searchResult = driver.findElements(By.cssSelector("div"));
        for (WebElement webElement : searchResult) {
            if (webElement.getText().contains("https://www.selenium.dev")) {
                isDetected = true;
                break;
            }
        }
        assertTrue(isDetected);
        driver.quit();
    }

    @Test
    public void loginE2ESeleniumTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userField = driver.findElement(By.id("user-name"));
        WebElement passwdField = driver.findElement(By.id("password"));
        WebElement submitField = driver.findElement(By.id("login-button"));
        userField.sendKeys("standard_user");
        passwdField.sendKeys("secret_sauce");
        submitField.click();
        WebElement title = driver.findElement(By.className("title"));
        assertTrue(title.getText().contains("Products"));
        driver.quit();
    }
}
