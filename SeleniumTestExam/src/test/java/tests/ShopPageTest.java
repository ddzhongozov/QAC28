package tests;

import core.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ShopPage;
import utils.WaitTool;

public class ShopPageTest extends BaseTest {


    @Test
    public void clickRegisterButton() {
        ShopPage.goToShopPage();
        ShopPage.clickMyAccount();
        WaitTool.waitForElementVisibility(By.cssSelector("li.dropdown.open > ul > li:nth-child(1) > a"), 3);
        ShopPage.clickRegister();
    }
}
