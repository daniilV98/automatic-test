package org.example.homework6.pages;

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

    public NewTvPage clickOnNewTvButton() {
        newTvButton.click();
        return new NewTvPage(driver);
    }

}
