package org.example.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Auth {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.get("https://www.ivi.ru/");
        WebElement auth = driver.findElement(By.xpath("//a[@class='user-badge__icon js-profile-link user-badge__icon_link ']"));
        auth.click();
        auth = driver.findElement(By.xpath("//span[@class='button__icon button__icon_avatar']"));
        auth.click();
        auth = driver.findElement(By.name("email"));
        auth.click();
        auth.sendKeys("frank11256303@gmail.com");
        auth = driver.findElement(By.xpath("//button[@class='nbl-button nbl-button nbl-button_iconMode_noIcon nbl-button_style_kioshi nbl-button_size_shinnok chat-button__nbl-button']"));
        auth.click();
        auth = driver.findElement(By.xpath("//input[@data-test='input_password']"));
        auth.click();
        auth.sendKeys("qwerty1234");
        auth = driver.findElement(By.xpath("//span[@class='nbl-button__primaryText']"));
        auth.click();

        driver.quit();



    }
}
