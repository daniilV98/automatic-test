package org.example.homeworkTest5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JsExecutorAuthTest {

    private final String LOGIN_PAGE_URL = "https://www.ivi.ru";
    private final String LOGIN = "frank11256303@gmail.com";
    private final String PASSWORD = "qwerty1234";
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
        login();

        Assertions.assertTrue(!(LOGIN.isEmpty() && PASSWORD.isEmpty()), "Login or password incorrect!");
    }

    private void login() {
        driver.get(LOGIN_PAGE_URL);

        By profileButton = By.xpath("//a[@class='user-badge__icon js-profile-link user-badge__icon_link ']");
        By entryOrRegistrationButton = By.xpath("//span[@class='button__icon button__icon_avatar']");
        By loginTextInput = By.name("email");
        By continueButton = By.xpath("//button[@class='nbl-button nbl-button nbl-button_iconMode_noIcon nbl-button_style_kioshi nbl-button_size_shinnok chat-button__nbl-button']");
        By passwordTextInput = By.xpath("//input[@type='password']");
        By entryButton = By.xpath("//span[@class='nbl-button__primaryText']");

        WebElement profileButtonLocator = driver.findElement(profileButton);
        jsExecutor.executeScript("arguments[0].click();", profileButtonLocator); // using jsExecutor

        WebElement entryOrRegistrationButtonLocator = driver.findElement(entryOrRegistrationButton);
        jsExecutor.executeScript("arguments[0].click();", entryOrRegistrationButtonLocator); // using jsExecutor

        WebElement loginTextInputLocator = driver.findElement(loginTextInput);
        loginTextInputLocator.sendKeys(LOGIN);

        WebElement continueButtonLocator = driver.findElement(continueButton);
        jsExecutor.executeScript("arguments[0].click();", continueButtonLocator); // using jsExecutor

        WebElement passwordTextInputLocator = driver.findElement(passwordTextInput);
        passwordTextInputLocator.sendKeys(PASSWORD);

        WebElement entryButtonLocator = driver.findElement(entryButton);
        jsExecutor.executeScript("arguments[0].click();", entryButtonLocator); // using jsExecutor
    }
}
