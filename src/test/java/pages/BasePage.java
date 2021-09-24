package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    protected void type(String text,By locator){
         find(locator).sendKeys(text);
    }

    protected void click(By locator){
        find(locator).click();
    }

    protected void pressEnter(Keys key,By locator){
        find(locator).sendKeys(key);
    }

    protected void waitVisibilityOf(By locator) {

        wait.until(ExpectedConditions.visibilityOf(find(locator)));
    }
}
