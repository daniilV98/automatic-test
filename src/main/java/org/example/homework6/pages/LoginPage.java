package org.example.homework6.pages;

import org.example.homework6.base.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public LoginPage clickProfileButton() {
        retryingFindClick(profileXpathButton);
       return this;
    }

    public LoginPage clickEntryOrRegistrationButton() {
        entryOrRegistrationButton.click();
        return this;
    }

    public LoginPage inputLoginLine(String login) {
        loginInputLine.sendKeys(login);
        return this;
    }

    public LoginPage clickContinueButton() {
        continueButton.click();
        return this;
    }

    public LoginPage inputPasswordLine(String password) {
        passwordInputLine.sendKeys(password);
        return this;
    }

    public LoginPage clickEntryButton() {
        entryButton.click();
        return this;
    }

    /**
     * Реализация метода для поиска элемента, пока элемент не найден, чтобы тест не падал сразу
     * */
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
    public void clickPopUp(By by) {
        boolean pop = true;
        if (pop) {
            driver.findElement(by).click();
        }
    }
    /**
     * Реализация pop-up кнопки, для метода выше
     * */
    public LoginPage clickPopUpButton() {
        clickPopUp(popUp);
        return this;
    }

    /**
     * Реализация метода авторизации для использования в других методах
     * */
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
