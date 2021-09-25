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
    private By viewGridTypeResult = By.xpath("//*[@id=\'grid\']");
    private By viewListTypeResult = By.xpath("//*[@id=\'list\']");
    private By itemsListFound = By.xpath("//*[@id='center_column']/ul/li[*]");
    private By addToCartButton = By.xpath(".//*[contains(@class,'button ajax_add_to_cart_button btn btn-default')]");
    private By titleItemAddToCart = By.xpath(".//*[(@class='product-name' and @itemprop='url')]");
    private By layerProductAddedSuccessfully  = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6");
    private By productAddedCartName = By.id("layer_cart_product_title");

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

    public void selectViewType(int viewType){
        switch (viewType){
            case 1:
                click(viewGridTypeResult);
                break;
            case 2:
                click(viewListTypeResult);
                break;
        }
    }

    public void clicOnAddToCartButton(){

        clicOnSpecificAddToCartOption(itemsListFound,addToCartButton,1);
    }

    public String getProductNameToAddCart(){

        return getTextSpecificAddToCartItem(itemsListFound,titleItemAddToCart,1);
    }

    public String getProductNameAddedCart(){

        return getText(productAddedCartName);
    }

    public void scrollDownUntilElement(){
        scrollDownUntilElementFound(itemsListFound);
    }

    public void waitLayerProductAddedSuccessfullyAppear(){waitVisibilityOf(layerProductAddedSuccessfully);}

    public boolean isDisplayedLayerProductAddedSuccessfully(){
        return find(layerProductAddedSuccessfully).isDisplayed();
    }


}
