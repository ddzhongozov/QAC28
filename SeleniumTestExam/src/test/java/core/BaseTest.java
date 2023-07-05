package core;

import org.testng.annotations.BeforeClass;
import utils.Browser;

public abstract class BaseTest {


    @BeforeClass
    public void setupBrowser() {
        Browser.setup();
    }

    /*@AfterClass
    public void tearDownBrowser() {
        Browser.tearDown();
    }*/
}
