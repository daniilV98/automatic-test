package org.example.homeworkTest6;

import io.qameta.allure.Feature;
import org.example.homework6.pages.FilterPage;
import org.example.homeworkTest6.base.BaseUITest;
import org.junit.jupiter.api.Test;

@Feature("Filter")
public class PositiveFilterTest extends BaseUITest {

    /**
     * Тест на поиск фильма по фильтрам
     * */
    @Test
    public void searchFilmTest() {
        new FilterPage(driver)
                .clickFilterFilmButton()
                .clickFilterFilterButton()
                .clickFilterGenre()
                .clickFilterCountryButton()
                .clickFilterCountry()
                .clickFilterYearButton()
                .clickFilterYear()
                .clickFilterSubgenresButton()
                .clickFilterSubgenres()
                .clickFilterLanguageButton()
                .clickFilterResultsButton();
    }
}
