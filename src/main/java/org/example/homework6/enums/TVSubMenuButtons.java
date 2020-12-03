package org.example.homework6.enums;

import org.example.homework6.base.SubMenuButtons;
import org.openqa.selenium.By;

public enum TVSubMenuButtons implements SubMenuButtons {

    TV_REQUEST("//a[@class='top-menu__sublist-link' and text()='Спорт']");

    private final By by;

    TVSubMenuButtons(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}
