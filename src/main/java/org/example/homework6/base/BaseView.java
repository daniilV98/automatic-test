package org.example.homework6.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseView {

    protected WebDriver driver;
    protected WebDriverWait wait5seconds;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        this.wait5seconds = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver,this);
    }


}
