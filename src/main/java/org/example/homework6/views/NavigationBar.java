package org.example.homework6.views;

import org.example.homework6.base.BaseView;
import org.example.homework6.base.SubMenu;
import org.example.homework6.enums.NavigationBarTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationBar extends BaseView {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    /**
     * Реализация метода для наведения на кнопку TV+
     * */
    public SubMenu moveCursorToNavigationTab(NavigationBarTabs tab) {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(tab.getBy()))
                .build()
                .perform();
        switch (tab) {
            case TV_BUTTON:
                return new TVSubMenu(driver);
            default:
                throw new IllegalArgumentException("Another tabs currently not implemented");
        }
    }
}
