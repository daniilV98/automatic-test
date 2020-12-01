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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FilterTest {

    private final String PAGE_URL = "https://www.ivi.ru";
    private WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeAll
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpTest() {
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
        filter();
    }

    private void filter() {
        driver.get(PAGE_URL);

        /*By filterFilmButton = By.xpath("//a[@data-ui-id='films']");*/
        By filterFilterButton = By.xpath("//span[text()='Фильтры']");
        By filterGenre = By.xpath("//span[text()='Боевики']");
        By filterCountryButton = By.xpath("//span[text()='Страны']");
        By filterCountry = By.xpath("//span[@class='nbl-checkbox__label']//*[text()='Великобритания']");
        By filterYearButton = By.xpath("//span[text()='Годы']");
        By filterYear = By.xpath("//span[@class='nbl-radiobutton__label']//*[text()='2019 год']");
        By filterSubgenresButton = By.xpath("//span[text()='Поджанры']");
        By filterSubgenres = By.xpath("//span[@class='nbl-radiobutton__label']//*[text()='Комедийные боевики']");
        By filterLanguageButton = By.xpath("//span[text()='Язык оригинала']");
        By filterResultsButton = By.xpath("//span[@class='nbl-button__primaryText']//*[@class='nbl-icon nbl-icon_filter_16 nbl-button__nbl-icon']");

        Actions actions = new Actions(driver);
        /*WebElement filterFilmButtonLocator = driver.findElement(filterFilmButton);
        actions.moveToElement(filterFilmButtonLocator).click().build().perform();*/

        jsExecutor.executeScript("window.open('https://www.ivi.ru/movies')");   //тут я решил попробовать применить switchTo(), конечно не в лучшем виде
        System.out.println(driver.getWindowHandles());
        List<String> tabs = new ArrayList(driver.getWindowHandles());

        tabs.forEach(tab -> {
            System.out.println(tab);
            driver.switchTo().window(tab);
        });

        WebElement filterFilterButtonLocator = driver.findElement(filterFilterButton);
        actions.moveToElement(filterFilterButtonLocator).click().build().perform();

        WebElement filterGenreLocator = driver.findElement(filterGenre);
        filterGenreLocator.click();

        WebElement filterCountryButtonLocator = driver.findElement(filterCountryButton);
        actions.moveToElement(filterCountryButtonLocator).click().build().perform();

        WebElement filterCountryLocator = driver.findElement(filterCountry);
        filterCountryLocator.click();

        WebElement filterYearButtonLocator = driver.findElement(filterYearButton);
        actions.moveToElement(filterYearButtonLocator).click().build().perform();

        WebElement filterYearLocator = driver.findElement(filterYear);
        filterYearLocator.click();

        WebElement filterSubgenresButtonLocator = driver.findElement(filterSubgenresButton);
        actions.moveToElement(filterSubgenresButtonLocator).click().build().perform();

        WebElement filterSubgenresLocator = driver.findElement(filterSubgenres);
        filterSubgenresLocator.click();

        WebElement filterLanguageButtonLocator = driver.findElement(filterLanguageButton);
        actions.moveToElement(filterLanguageButtonLocator).click().build().perform();

        WebElement filterResultsButtonLocator = driver.findElement(filterResultsButton);
        actions.moveToElement(filterResultsButtonLocator).click().build().perform();
    }
    /**
     * отдельно попробовал тест на переключение страниц
     * */
    @Test
    public void switchTest() throws InterruptedException {
        driver.get(PAGE_URL);

        for (int i=0; i<1; i++) {
            jsExecutor.executeScript("window.open('https://www.ivi.ru/movies')");
            Thread.sleep(1000);
            System.out.println(driver.getWindowHandles());
        }

        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());

        tabs.forEach(tab ->{
            System.out.println(tab);
            driver.switchTo().window(tab);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }
}