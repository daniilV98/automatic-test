package org.example.homeworkTest5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionsAuthTest {

    private final String LOGIN_PAGE_URL = "https://www.ivi.ru";
    private final String LOGIN = "frank11256303@gmail.com";
    private final String PASSWORD = "qwerty1234";
    private WebDriver driver;

    @BeforeAll
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void beforeTest() {
        setUpDriverSession();
        login();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void createNewTest() {

        Actions actions = new Actions(driver);

        By entryButton = By.xpath("//span[@class='nbl-button__primaryText']");

        WebElement entryButtonLocator = driver.findElement(entryButton);
        actions.moveToElement(entryButtonLocator);
        actions.click().build().perform();

        Assertions.assertTrue(entryButtonLocator.isDisplayed(),"Not found element!");
        Assertions.assertTrue(!(LOGIN.isEmpty() && PASSWORD.isEmpty()), "Login or password incorrect!");
    }

    private void login() {
        driver.get(LOGIN_PAGE_URL);

        By profileButton = By.xpath("//a[@class='user-badge__icon js-profile-link user-badge__icon_link ']");
        By entryOrRegistrationButton = By.xpath("//span[@class='button__icon button__icon_avatar']");
        By loginTextInput = By.name("email");
        By continueButton = By.xpath("//button[@class='nbl-button nbl-button nbl-button_iconMode_noIcon nbl-button_style_kioshi nbl-button_size_shinnok chat-button__nbl-button']");
        By passwordTextInput = By.xpath("//input[@type='password']");

        WebElement profileButtonLocator = driver.findElement(profileButton);
        profileButtonLocator.click();

        WebElement entryOrRegistrationButtonLocator = driver.findElement(entryOrRegistrationButton);
        entryOrRegistrationButtonLocator.click();

        WebElement loginTextInputLocator = driver.findElement(loginTextInput);
        loginTextInputLocator.sendKeys(LOGIN);

        WebElement continueButtonLocator = driver.findElement(continueButton);
        continueButtonLocator.click();

        WebElement passwordTextInputLocator = driver.findElement(passwordTextInput);
        passwordTextInputLocator.sendKeys(PASSWORD);
    }

    private void setUpDriverSession() {
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
