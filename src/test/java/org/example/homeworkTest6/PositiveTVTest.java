package org.example.homeworkTest6;

import org.example.homework6.pages.TVPage;
import org.example.homeworkTest6.base.BaseUITest;
import org.junit.jupiter.api.Test;

public class PositiveTVTest extends BaseUITest {

    /**
     * Обычный тест на окрытие TV канала
     * */
    @Test
    public void openTVTest() {
        new TVPage(driver)
                .clickTVPlusButton()
                .clickSportButton()
                .clickChannelButton();
    }
}
