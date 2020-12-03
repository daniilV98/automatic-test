package org.example.homeworkTest6;

import org.example.homework6.pages.SearchPage;
import org.example.homeworkTest6.base.BaseUITest;
import org.junit.jupiter.api.Test;

import static org.example.homeworkTest6.common.Configuration.NAME_OF_FILM;

public class PositiveSearchTest extends BaseUITest {

    /**
     * Тест на поиск фильма по названию
     * */
    @Test
    public void searchFilmTest() {
        new SearchPage(driver)
                .clickSearchButton()
                .inputSearchTextInput(NAME_OF_FILM)
                .clickSearchTakeFilm();
    }
}
