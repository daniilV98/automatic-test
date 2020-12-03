package org.example.homework6.pages;

import io.qameta.allure.Step;
import org.example.homework6.base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllTvPage extends BaseView {

    @FindBy(xpath = "//div[@data-index='0']")
    private WebElement newTvButton;

    public AllTvPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Click on tv button")
    public NewTvPage clickOnNewTvButton() {
        newTvButton.click();
        makeScreen();
        return new NewTvPage(driver);
    }

}
