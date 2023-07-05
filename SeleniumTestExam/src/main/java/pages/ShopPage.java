package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class ShopPage extends BasePage {

    private static final String SHOP_PAGE_URL = "http://shop.pragmatic.bg";

    private static final By MY_ACCOUNT_MENU = By.cssSelector("span[class='caret']");

    private static final By REGISTER_BUTTON = By.cssSelector("li.dropdown.open > ul > li:nth-child(1) > a");

    public static void goToShopPage() {
        driver.get(SHOP_PAGE_URL);
    }

    public static void clickMyAccount() {
        clickOnElementByLocator(MY_ACCOUNT_MENU);
    }

    public static void clickRegister() {
        clickOnElementByLocator(REGISTER_BUTTON);
    }


}
