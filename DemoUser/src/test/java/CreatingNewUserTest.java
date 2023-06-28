import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreatingNewUserTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://shop.pragmatic.bg/admin");
        driver.manage().window().maximize();
    }

    @Test
    public void creatingUserTest() {
        driver.findElement(By.id("input-username")).sendKeys("admin");
        WebElement passwordInputField = driver.findElement(By.id("input-password"));
        passwordInputField.sendKeys("parola123!");
        passwordInputField.submit();
        WebElement customersDropdown = driver.findElement(By.cssSelector("#menu-customer>a"));
        customersDropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement customersLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse5 > li:nth-child(1) > a")));
        customersLabel.click();
        WebElement plusButton = driver.findElement(By.xpath("//*[@class='fa fa-plus']/ .."));
        plusButton.click();
        driver.findElement(By.id("input-firstname")).sendKeys("Milen");
        driver.findElement(By.id("input-lastname")).sendKeys("Bozhinov");
        String prefix = RandomStringUtils.randomAlphabetic(7);
        String sufix = RandomStringUtils.randomAlphabetic(5);
        String domain = RandomStringUtils.randomAlphabetic(3);
        String emailAddress = prefix + "@" + sufix + "." + domain;
        driver.findElement(By.id("input-email")).sendKeys(emailAddress);

        //TODO: YOUR HOMEWORK STARTS HERE! BELOW!
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

}
