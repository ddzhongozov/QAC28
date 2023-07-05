package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ConfirmationPage extends BasePage {

    private static final By NEW_ACCOUNT_CONFIRMATION = By.cssSelector("p:nth-child(2)");

    public static void confirmationMessageText(String expecteConfirmationMessage) {
        String actualConfirmationMessage = driver.findElement(NEW_ACCOUNT_CONFIRMATION).getText();
        Assert.assertEquals(actualConfirmationMessage,expecteConfirmationMessage);
    }
}
