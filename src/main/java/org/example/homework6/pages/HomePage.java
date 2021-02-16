package org.example.homework6.pages;

import io.qameta.allure.Step;
import org.example.homework6.base.BaseView;
import org.example.homework6.views.NavigationBar;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseView {

    private NavigationBar navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    @Step(value = "Get page navigation")
    public NavigationBar getPageNavigation() {
        return navigationBar;
    }
}
