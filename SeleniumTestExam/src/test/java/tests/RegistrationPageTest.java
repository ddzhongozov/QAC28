package tests;

import core.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.RegistrationPage;
import pages.ShopPage;
import utils.WaitTool;

public class RegistrationPageTest extends ShopPageTest {
    
    @Test
    public void createNewAccount() {
        clickRegisterButton();
        RegistrationPage.typeFirstLastName("Dimitar","Dzhongozov");
        RegistrationPage.typeEmailAddress();
        RegistrationPage.typePhoneNumber();
        RegistrationPage.typePasswordConfirmPassword();
        RegistrationPage.agreeButtonClick();
        RegistrationPage.continueButtonClick();
        ConfirmationPage.confirmationMessageText("Congratulations! Your new account has been successfully created!");

    }


    }

