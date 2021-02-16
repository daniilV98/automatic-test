package org.example.homeworkTest6;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.homework6.helpers.ScreenShotMaker;
import org.example.homework6.pages.LoginPage;
import org.example.homeworkTest6.base.BaseUITest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static org.example.homeworkTest6.common.Configuration.*;

@Feature("Login")
@Severity(SeverityLevel.BLOCKER)
public class PositiveLoginTest extends BaseUITest {

    /**
     * Тест на авторизацию
     * */
    @Test
    public void loginProfileTest() {
        new LoginPage(driver)
                .clickProfileButton()
                .clickEntryOrRegistrationButton()
                .inputLoginLine(LOGIN)
                .clickContinueButton()
                .inputPasswordLine(PASSWORD)
                .clickEntryButton();
        /*.checkUrl(BASE_URL);*/

        ScreenShotMaker.makeScreenshot(driver, "login.jpg");
    }
}
