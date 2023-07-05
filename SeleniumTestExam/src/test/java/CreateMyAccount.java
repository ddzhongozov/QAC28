import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateMyAccount {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://shop.pragmatic.bg/");
        driver.manage().window().maximize();
    }

    @Test
    public void createMyAccount() {

        WebElement myAccountButton = driver.findElement(By.cssSelector("span[class='caret']"));
        myAccountButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.dropdown.open > ul > li:nth-child(1) > a")));
        registerButton.click();

        //Names
        driver.findElement(By.id("input-firstname")).sendKeys("Dimitar");
        driver.findElement(By.id("input-lastname")).sendKeys("Dzhongozov");

        //E-mail address
        String sufix = RandomStringUtils.randomAlphabetic(5);
        String domain = RandomStringUtils.randomAlphabetic(3);
        String emailAddress = "Dimitar" + "@" + sufix + "." + domain;
        driver.findElement(By.id("input-email")).sendKeys(emailAddress);

        //Phone number
        String telephoneRandom = RandomStringUtils.randomNumeric(6);
        String phoneNumber = ("+359898" + telephoneRandom);
        driver.findElement(By.id("input-telephone")).sendKeys(phoneNumber);

        //Password
        String password = RandomStringUtils.randomAlphabetic(8);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(password);

        //Terms and conditions
        WebElement agreeButton = driver.findElement(By.cssSelector("input[name='agree']"));
        agreeButton.click();
        Assert.assertTrue(agreeButton.isSelected());

        //Continue
        driver.findElement(By.cssSelector("input[value='Continue']")).click();

        //Account creation confirmation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p:nth-child(2)")));

        String confirmedAccountCreation = driver.findElement(By.cssSelector("p:nth-child(2)")).getText();
        Assert.assertEquals(confirmedAccountCreation,"Congratulations! Your new account has been successfully created!");

    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
