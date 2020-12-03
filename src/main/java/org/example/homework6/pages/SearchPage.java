package org.example.homework6.pages;

import io.qameta.allure.Step;
import org.example.homework6.base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BaseView {

    @FindBy(xpath = "//label[@class='top-search__search-toggle js-search-open']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='nbl-input__editbox']")
    private WebElement searchTextInput;

    @FindBy(xpath = "//a[@data-content-id='93557']")
    private WebElement searchTakeFilm;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Click on search button")
    public SearchPage clickSearchButton() {
        searchButton.click();
        makeScreen();
        return this;
    }

    @Step(value = "Input search film name")
    public SearchPage inputSearchTextInput(String filmName) {
        searchTextInput.sendKeys(filmName);
        searchTextInput.submit();
        makeScreen();
        return this;
    }

    @Step(value = "Click on search button")
    public SearchPage clickSearchTakeFilm() {
        searchTakeFilm.click();
        makeScreen();
        return this;
    }
}
