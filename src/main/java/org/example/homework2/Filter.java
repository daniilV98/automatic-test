package org.example.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Filter {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.ivi.ru/");
        WebElement filter = driver.findElement(By.xpath("//a[@data-ui-id='films']"));
        filter.click();
        filter = driver.findElement(By.cssSelector(".nbl-filterTile__caption"));
        filter.click();
        filter = driver.findElement(By.xpath("//span[text()='Боевики']"));
        filter.click();
        filter = driver.findElement(By.xpath("//span[text()='Страны']"));
        filter.click();
        filter = driver.findElement(By.xpath("//span[@class='nbl-checkbox__label']//*[text()='Великобритания']"));
        filter.click();
        filter = driver.findElement(By.xpath("//span[text()='Годы']"));
        filter.click();
        filter = driver.findElement(By.xpath("//span[@class='nbl-radiobutton__label']//*[text()='2019 год']"));
        filter.click();
        filter = driver.findElement(By.xpath("//span[text()='Поджанры']"));
        filter.click();
        filter = driver.findElement(By.xpath("//span[@class='nbl-radiobutton__label']//*[text()='Комедийные боевики']"));
        filter.click();
        filter = driver.findElement(By.xpath("//span[text()='Язык оригинала']"));
        filter.click();
        filter = driver.findElement(By.xpath("//span[@class='nbl-button__primaryText']//*[@class='nbl-icon nbl-icon_filter_16 nbl-button__nbl-icon']"));
        filter.click();

        driver.quit();



    }
}
