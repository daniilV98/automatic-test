package org.example.homework6.views;

import org.example.homework6.base.BaseView;
import org.example.homework6.base.SubMenu;
import org.example.homework6.base.SubMenuButtons;
import org.example.homework6.enums.TVSubMenuButtons;
import org.example.homework6.pages.AllTvPage;
import org.openqa.selenium.WebDriver;

public class TVSubMenu extends SubMenu {

    public TVSubMenu(WebDriver driver) {
        super(driver);
    }

    /**
     * Реализация метода для клика кнопки внутри TV+ бара
     * */
    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof TVSubMenuButtons) {
            switch ((TVSubMenuButtons) buttons) {
                case TV_REQUEST:
                    driver.findElement(((TVSubMenuButtons) buttons).getBy()).click();
                    return new AllTvPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}
