package org.example.homework6.pages;

import io.qameta.allure.Step;
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

    @Step(value = "Click on film button")
    public FilterPage clickFilterFilmButton() {
        filterFilmButton.click();
        makeScreen();
        return this;
    }

    @Step(value = "Click on filter button")
    public FilterPage clickFilterFilterButton() {
        filterFilterButton.click();
        makeScreen();
        return this;
    }

    @Step(value = "Choose of Genre")
    public FilterPage clickFilterGenre() {
        filterGenre.click();
        makeScreen();
        return this;
    }

    @Step(value = "Click on country button ")
    public FilterPage clickFilterCountryButton() {
        filterCountryButton.click();
        makeScreen();
        return this;
    }

    @Step(value = "Choose of country")
    public FilterPage clickFilterCountry() {
        filterCountry.click();
        makeScreen();
        return this;
    }

    @Step(value = "Click on year button")
    public FilterPage clickFilterYearButton() {
        filterYearButton.click();
        makeScreen();
        return this;
    }

    @Step(value = "Choose of year")
    public FilterPage clickFilterYear() {
        filterYear.click();
        makeScreen();
        return this;
    }

    @Step(value = "Click on subgenres button")
    public FilterPage clickFilterSubgenresButton() {
        filterSubgenresButton.click();
        makeScreen();
        return this;
    }

    @Step(value = "Choose of subgenres")
    public FilterPage clickFilterSubgenres() {
        filterSubgenres.click();
        makeScreen();
        return this;
    }

    @Step(value = "Click on language button")
    public FilterPage clickFilterLanguageButton() {
        filterLanguageButton.click();
        makeScreen();
        return new FilterPage(driver);
    }

    @Step(value = "Click on results button")
    public FilterPage clickFilterResultsButton() {
        filterResultsButton.click();
        makeScreen();
        return this;
    }
}
