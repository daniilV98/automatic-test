package org.example.homework6.enums;

import org.openqa.selenium.By;

public enum  NavigationBarTabs {

    HOME_BUTTON("//img[@alt='ivi']"),
    MY_IVI_BUTTON("//a[@title='Мой ivi']"),
    FILMS_BUTTON("//a[@title='Фильмы онлайн']"),
    SERIALS_BUTTON("//a[@title='Сериалы онлайн']"),
    CARTOONS_BUTTON("//a[@title='Мультфильмы онлайн']"),
    TV_BUTTON("//a[@title='TV+']"),
    SPORT_BUTTON("//a[@title='Спорт']"),
    COLLECTIONS_BUTTON("//a[@title='Подборки']");

    private final By by;
    NavigationBarTabs(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}
