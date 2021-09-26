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
    private By closeButtonLayerProductAdded = By.xpath(".//*[(@class='cross' and @title='Close window')]");
    private By shoppingCartOption = By.xpath("//*[@id=\'header\']/div[3]/div/div/div[3]/div/a");
    private By shoppingCartCounter = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity");
    private By noResultsSearchingAlert = By.xpath("//*[@id=\'center_column\']/p");
    private By storeInformationsBlock = By.id("block_contact_infos");
    private By storeInformationAddress = By.xpath("//*[@id='block_contact_infos']/div/ul/li[1]");
    private By storeInformationPhoneNumber = By.xpath("//*[@id=\'block_contact_infos\']/div/ul/li[2]/span");
    private By storeInformationEmail = By.xpath("//*[@id=\'block_contact_infos\']/div/ul/li[3]/span/a");

    public void setCriteriaToSearch(String criteria){

        type(criteria,searchBarField);
    }

    public void pressEnterKeyBarField(){

        pressAnyKey(Keys.ENTER,searchBarField);
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

        clicOnSpecificAddToCartOption(itemsListFound,
                                        addToCartButton,
                                        1);
    }

    public String getProductNameToAddCart(){
        return getTextSpecificAddToCartItem(itemsListFound,titleItemAddToCart,
                1);
    }

    public String getProductNameAddedCart(){

        return getText(productAddedCartName);
    }

    public boolean wereProductsFound(){

        if(getCountItemsFound() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void waitLayerProductAddedSuccessfullyAppear(){

        waitVisibilityOf(layerProductAddedSuccessfully);
    }

    public boolean isDisplayedLayerProductAddedSuccessfully(){
        return find(layerProductAddedSuccessfully).isDisplayed();
    }

    public void closeLayerProductAddedSuccessfully(){

        click(closeButtonLayerProductAdded);
    }

    public void waitLayerProductAddedSuccessfullyDisappear(){

        waitInvisibilityOf(layerProductAddedSuccessfully);
    }

    public void clicShoppingCartOption(){

        click(shoppingCartOption);
    }

    public void waitTextPresentInElement(){

        waitTextPresentInElement(noResultsSearchingAlert,
                "No results were found for your search \"camisa\"");
    }

    public void scrollDownUntilStoreInformationBlock(){

        scrollDownUntilElementFound(storeInformationsBlock);
    }

    public boolean AreValidStoreInformations(String address,String phoneNumber,String email) {

        if (getText(storeInformationAddress).contentEquals(address)
                && getText(storeInformationPhoneNumber).contentEquals(phoneNumber)
                && getText(storeInformationEmail).contentEquals(email)) {
            return true;
        }
        else{
            return false;
        }

    }



}
