package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

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

    //to generate one random number between 0 and list.size() - 1
    protected int generateRandomInteger(int upperBound){

            Random random = new Random();

        return random.nextInt(upperBound);
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

    protected void pressAnyKey(Keys key,By locator){

        find(locator).sendKeys(key);
    }

    protected String getText(By locator){

        return find(locator).getText();
    }

    protected void waitVisibilityOf(By locator) {

        wait.until(ExpectedConditions.visibilityOf(find(locator)));
    }

    protected void waitTextPresentInElement(By locator,String text){
        wait.until(ExpectedConditions.textToBe(locator,text));
    }

    protected void waitInvisibilityOf(By locator) {

        wait.until(ExpectedConditions.invisibilityOf(find(locator)));
    }

    protected void scrollDownUntilElementFound(By locator){

        js.executeScript("arguments[0].scrollIntoView();"
                ,find(locator));
    }

    protected boolean isElementDisplayed(By locator){

        return find(locator).isDisplayed();
    }
}
