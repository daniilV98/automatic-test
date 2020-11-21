package org.example.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

public class Search {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.get("https://www.ivi.ru/");
        WebElement search = driver.findElement(By.xpath("//label[@class='top-search__search-toggle js-search-open']"));
        search.click();
        search = driver.findElement(By.xpath("//input[@class='nbl-input__editbox']"));
        search.click();
        search.sendKeys("Мстители");
        search.submit();
        search = driver.findElement(By.xpath("//a[@data-content-id='93557']"));
        search.click();

        driver.quit();
    }
}
