package org.example.homework6.pages;

import org.example.homework6.base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage extends BaseView {

    @FindBy(xpath = "//a[@data-ui-id='films']")
    private WebElement filterFilmButton;

    @FindBy(xpath = "//span[text()='Фильтры']")
    private WebElement filterFilterButton;

    @FindBy(xpath = "//span[text()='Боевики']")
    private WebElement filterGenre;

    @FindBy(xpath = "//span[text()='Страны']")
    private WebElement filterCountryButton;

    @FindBy(xpath = "//span[@class='nbl-checkbox__label']//*[text()='Великобритания']")
    private WebElement filterCountry;

    @FindBy(xpath = "//span[text()='Годы']")
    private WebElement filterYearButton;

    @FindBy(xpath = "//span[@class='nbl-radiobutton__label']//*[text()='2019 год']")
    private WebElement filterYear;

    @FindBy(xpath = "//span[text()='Поджанры']")
    private WebElement filterSubgenresButton;

    @FindBy(xpath = "//span[@class='nbl-radiobutton__label']//*[text()='Комедийные боевики']")
    private WebElement filterSubgenres;

    @FindBy(xpath = "//span[text()='Язык оригинала']")
    private WebElement filterLanguageButton;

    @FindBy(xpath = "//span[@class='nbl-button__primaryText']//*[@class='nbl-icon nbl-icon_filter_16 nbl-button__nbl-icon']")
    private WebElement filterResultsButton;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage clickFilterFilmButton() {
        filterFilmButton.click();
        return this;
    }

    public FilterPage clickFilterFilterButton() {
        filterFilterButton.click();
        return this;
    }

    public FilterPage clickFilterGenre() {
        filterGenre.click();
        return this;
    }

    public FilterPage clickFilterCountryButton() {
        filterCountryButton.click();
        return this;
    }

    public FilterPage clickFilterCountry() {
        filterCountry.click();
        return this;
    }

    public FilterPage clickFilterYearButton() {
        filterYearButton.click();
        return this;
    }

    public FilterPage clickFilterYear() {
        filterYear.click();
        return this;
    }

    public FilterPage clickFilterSubgenresButton() {
        filterSubgenresButton.click();
        return this;
    }

    public FilterPage clickFilterSubgenres() {
        filterSubgenres.click();
        return this;
    }

    public FilterPage clickFilterLanguageButton() {
        filterLanguageButton.click();
        return new FilterPage(driver);
    }

    public FilterPage clickFilterResultsButton() {
        filterResultsButton.click();
        return this;
    }
}
