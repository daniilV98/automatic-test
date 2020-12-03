package org.example.homework6.pages;

import io.qameta.allure.Step;
import org.example.homework6.base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVPage extends BaseView {

    @FindBy(xpath = "//a[@data-groot-id='menu_tv_plus']")
    private WebElement tvPlusButton;

    @FindBy(xpath = "//span[text()='Спорт']")
    private WebElement sportButton;

    @FindBy(xpath = "//div[@data-index='0']")
    private WebElement channelButton;

    public TVPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Click on TV+ button")
    public TVPage clickTVPlusButton() {
        tvPlusButton.click();
        makeScreen();
        return this;
    }

    @Step(value = "Click on button of Sport")
    public TVPage clickSportButton() {
        sportButton.click();
        makeScreen();
        return this;
    }

    @Step(value = "Click on channel button")
    public TVPage clickChannelButton() {
        channelButton.click();
        makeScreen();
        return this;
    }
}
