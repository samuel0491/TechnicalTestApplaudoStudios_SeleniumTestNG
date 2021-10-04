package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import pages.YourLogoHomePage;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    //protected ChromeDriver driver;
    protected WebDriver driver;
    private final String URL = "http://automationpractice.com/index.php";//TODO: this value could be in a config file
    protected YourLogoHomePage yourLogoHomePage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser)throws Exception{

            switch (browser.toLowerCase()){

                case "chrome":
                    setWebDriverProperty("webdriver.chrome.driver",
                            "chromedriver.exe");
                        driver = new ChromeDriver();
                    break;

                case "firefox":
                    setWebDriverProperty("webdriver.gecko.driver",
                            "geckodriver.exe");
                        driver = new FirefoxDriver();
                    break;

                case "ie":
                    setWebDriverProperty("webdriver.ie.driver",
                            "IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;

                default:
                    setWebDriverProperty("webdriver.chrome.driver",
                            "chromedriver.exe");
                    driver = new ChromeDriver();
            }
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

    public void setWebDriverProperty(String pathDriver, String driverRunner){

        System.setProperty(pathDriver,
                System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\"+driverRunner);
    }

    @AfterTest
    public void shutDown() throws Exception{
       driver.quit();
    }

}
