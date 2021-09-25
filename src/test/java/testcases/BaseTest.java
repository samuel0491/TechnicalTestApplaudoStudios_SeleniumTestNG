package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.YourLogoHomePage;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected ChromeDriver driver;
    private final String URL = "http://automationpractice.com/index.php";//TODO: this value could be in a config file
    protected YourLogoHomePage yourLogoHomePage;

    @BeforeTest
    public void setUp()throws Exception{
        //
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        //
        driver.manage()
                .window()
                .maximize();
        //
        driver.manage()
                .timeouts()
                .pageLoadTimeout(15, TimeUnit.SECONDS);
        //
        driver.get(URL);
        //
    }

    @AfterTest
    public void shutDown() throws Exception{
       driver.quit();
    }

}