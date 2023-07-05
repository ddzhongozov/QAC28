package pages;

import core.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

private static final By FIRST_NAME_INPUT = By.id("input-firstname");

private static final By LAST_NAME_INPUT = By.id("input-lastname");

private static final String sufix = RandomStringUtils.randomAlphabetic(5);
private static final String domain = RandomStringUtils.randomAlphabetic(3);
private static final String emailAddress = "Dimitar" + "@" + sufix + "." + domain;
private static final By EMAIL_INPUT = By.id("input-email");

private static final String telephoneRandom = RandomStringUtils.randomNumeric(6);
private static final String phoneNumber = ("+359898" + telephoneRandom);

private static final By PHONE_NUMBER = By.id("input-telephone");

private static final String password = RandomStringUtils.randomAlphabetic(8);

private static final By PASSWORD_INPUT = By.id("input-password");

private static final By PASSWORD_CONFIRM = By.id("input-confirm");

private static final WebElement termsAgreeButton = driver.findElement(By.cssSelector("input[name='agree']"));
private static final By CONTINUE_BUTTON = By.cssSelector("input[value='Continue']");



public static void typeFirstLastName(String firstname, String lastname) {
    driver.findElement(FIRST_NAME_INPUT).sendKeys(firstname);
    driver.findElement(LAST_NAME_INPUT).sendKeys(lastname);
}

public static void typeEmailAddress () {
    driver.findElement(EMAIL_INPUT).sendKeys(emailAddress);
}

public static void typePhoneNumber() {
    driver.findElement(PHONE_NUMBER).sendKeys(phoneNumber);
}

public static void typePasswordConfirmPassword(){
    driver.findElement(PASSWORD_INPUT).sendKeys(password);
    driver.findElement(PASSWORD_CONFIRM).sendKeys(password);
}

public static void agreeButtonClick() {
    if(!termsAgreeButton.isSelected())
        termsAgreeButton.click();
}

public static void continueButtonClick() {
    driver.findElement(CONTINUE_BUTTON).click();
}

}
