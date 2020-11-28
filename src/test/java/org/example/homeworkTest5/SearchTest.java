package org.example.homeworkTest5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SearchTest {

    private final String PAGE_URL = "https://www.ivi.ru";
    private final String NAME_OF_FILM = "Мстители";
    private WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeAll
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        jsExecutor = (JavascriptExecutor) driver;
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void openSite() {
        search();
    }

    private void search() {
        driver.get(PAGE_URL);

        By searchButton = By.xpath("//label[@class='top-search__search-toggle js-search-open']");
        By searchTextInput = By.xpath("//input[@class='nbl-input__editbox']");
        By searchTakeFilm = By.xpath("//a[@data-content-id='93557']");

        Actions actions = new Actions(driver);
        WebElement searchLocator = driver.findElement(searchButton);
        actions.moveToElement(searchLocator).click().build().perform();

        WebElement loginTextInputLocator = driver.findElement(searchTextInput);
        loginTextInputLocator.sendKeys(NAME_OF_FILM);
        loginTextInputLocator.submit();

        WebElement profileButtonLocator = driver.findElement(searchTakeFilm);
        jsExecutor.executeScript("arguments[0].click();", profileButtonLocator);
    }
}
