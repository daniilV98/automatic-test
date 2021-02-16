package org.example.homework6.base;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;

public abstract class BaseView {

    protected WebDriver driver;
    protected WebDriverWait wait5seconds;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        this.wait5seconds = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver,this);
    }

    /**
     * Метод для скрина на каждом шаге
     * */
    public void makeScreen() {
        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
