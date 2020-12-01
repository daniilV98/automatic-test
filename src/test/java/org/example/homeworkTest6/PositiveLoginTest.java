package org.example.homeworkTest6;

import org.example.homework6.pages.LoginPage;
import org.example.homeworkTest6.base.BaseUITest;

import org.junit.jupiter.api.Test;

import static org.example.homeworkTest6.common.Configuration.*;

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
    }
}
