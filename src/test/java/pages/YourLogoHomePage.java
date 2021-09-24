package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class YourLogoHomePage extends BasePage {

    public YourLogoHomePage(WebDriver driver){

        super(driver);
    }

    //webElements home page and home page with search results
    private By searchBarField = By.id("search_query_top");
    private By counterItemsFound = By.className("heading-counter");
    private By itemsListFound = By.cssSelector("#center_column > ul > li");

    public void setCriteriaToSearch(String criteria){

        type(criteria,searchBarField);
    }

    public void pressEnterKeyBarField(){
        pressEnter(Keys.ENTER,searchBarField);
    }

    public void waitUntilCounterItemAppear(){
        waitVisibilityOf(counterItemsFound);
    }

    public int getCountItemsFound(){
        return findElements(itemsListFound).size();
    }

}
