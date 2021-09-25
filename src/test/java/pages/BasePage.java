package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        js = (JavascriptExecutor) driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    protected void clicOnSpecificAddToCartOption(By listLocator,By option,int indexItemToClic){

       findElements(listLocator)
               .get(indexItemToClic)
               .findElement(option)
               .click();
    }

    protected String getTextSpecificAddToCartItem(By listLocator,By option,int indexItemToClic){

        return findElements(listLocator)
                .get(indexItemToClic)
                .findElement(option)
                .getText();
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

    protected String getText(By locator){
        return find(locator).getText();
    }

    protected void waitVisibilityOf(By locator) {

        wait.until(ExpectedConditions.visibilityOf(find(locator)));
    }

    protected void scrollDownUntilElementFound(By locator){

        js.executeAsyncScript("window.scrollBy(0,500)");
    }
}
