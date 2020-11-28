package org.example.homeworkTest5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CookieTest {

    private final String PAGE_URL = "https://www.ivi.ru";
    private final String TARGET_PAGE = "/search/?q=врослые";
    private WebDriver driver;

    @BeforeAll
    public static void setupVebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testWitchCookie() {

        By access = By.xpath("//div[@class='modal-status__content']");
        By movie = By.xpath("//li[@index='0']");

        driver.get(PAGE_URL + TARGET_PAGE);

        WebElement movieLocator = driver.findElement(movie);
        movieLocator.click();

        WebElement getAccess = driver.findElement(access);

        Assertions.assertTrue(getAccess.isDisplayed());
    }


    @Test
    public void testWithoutCookie() {
        driver.get(PAGE_URL);

        By access = By.xpath("//div[@class='modal-status__content']");

        driver.manage().deleteCookieNamed("block");
        driver.manage().deleteCookieNamed("promo_collection_params");
        driver.manage().deleteCookieNamed("saved_promo");
        driver.manage().deleteAllCookies();

        List<WebElement> banners = driver.findElements(access);

        Assertions.assertEquals(0, banners.size());
    }
}
