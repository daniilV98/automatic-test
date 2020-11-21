package org.example.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tv {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.ivi.ru/");
        WebElement tv = driver.findElement(By.xpath("//a[@data-groot-id='menu_tv_plus']"));
        tv.click();
        tv = driver.findElement(By.xpath("//span[text()='Спорт']"));
        tv.click();
        tv = driver.findElement(By.xpath("//div[@data-index='0']"));
        tv.click();

        driver.quit();
    }
}
