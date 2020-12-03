package org.example.homework6.pages;

import io.qameta.allure.Step;
import org.example.homework6.base.BaseView;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    By profileXpathButton = By.xpath("//a[@title='Войти в профиль']");
    By popUp = By.xpath("//div[@class='profile-viewing-guide__close']");

    @FindBy(xpath = "//a[@title='Войти в профиль']")
    private WebElement profileButton;

    @FindBy(xpath = "//span[@class='button__icon button__icon_avatar']")
    private WebElement entryOrRegistrationButton;

    @FindBy(name = "email")
    private WebElement loginInputLine;

    @FindBy(xpath = "//button[@class='nbl-button nbl-button nbl-button_iconMode_noIcon nbl-button_style_kioshi nbl-button_size_shinnok chat-button__nbl-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInputLine;

    @FindBy(xpath = "//button[@class='nbl-button nbl-button nbl-button_iconMode_noIcon nbl-button_style_kioshi nbl-button_size_shinnok chat-button__nbl-button']")
    private WebElement entryButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Click on profile button")
    public LoginPage clickProfileButton() {
        retryingFindClick(profileXpathButton);
        makeScreen();
       return this;
    }

    @Step(value = "Click on entry or registration button")
    public LoginPage clickEntryOrRegistrationButton() {
        entryOrRegistrationButton.click();
        makeScreen();
        return this;
    }

    @Step(value = "Enter login {login}")
    public LoginPage inputLoginLine(String login) {
        loginInputLine.sendKeys(login);
        makeScreen();
        return this;
    }

    @Step(value = "Click on continue button")
    public LoginPage clickContinueButton() {
        continueButton.click();
        makeScreen();
        return this;
    }

    @Step(value = "Enter password {password} ")
    public LoginPage inputPasswordLine(String password) {
        passwordInputLine.sendKeys(password);
        makeScreen();
        return this;
    }

    @Step(value = "Click on entry button")
    public LoginPage clickEntryButton() {
        entryButton.click();
        makeScreen();
        return this;
    }

    /**
     * Реализация метода для поиска элемента, пока элемент не найден, чтобы тест не падал сразу
     * */
    @Step(value = "Retrying find click")
    public void retryingFindClick(By by) {
        int attempts = 0;
        while (attempts < 5) {
            try {
                if (driver.findElement(by).isDisplayed()) {
                    driver.findElement(by).click();
                    break;
                }
            } catch(StaleElementReferenceException e) {
                System.out.println("Element not found");
            }
            attempts++;
            if (attempts == 5) {
                System.out.println("элемент не найден " + by);
            }
        }
    }

    /**
     * Реализация метода для клика pop-up кнопки после авторизации
     * */
    @Step(value = "Click on pop-up")
    public void clickPopUp(By by) {
        boolean pop = true;
        if (pop) {
            driver.findElement(by).click();
        }
    }
    /**
     * Реализация pop-up кнопки, для метода выше
     * */
    @Step(value = "Click on pop-up button")
    public LoginPage clickPopUpButton() {
        clickPopUp(popUp);
        return this;
    }

    /**
     * Реализация метода авторизации для использования в других методах
     * */
    @Step(value = "Auth with login = {login}, password = {password}")
    public HomePage authoriseScenario(String login, String password) {
                clickProfileButton()
                .clickEntryOrRegistrationButton()
                .inputLoginLine(login)
                .clickContinueButton()
                .inputPasswordLine(password)
                .clickEntryButton()
                .clickPopUpButton();
        return new HomePage(driver);
    }


}
