package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    private By orderStepsBar = By.id("order_step");
    private By orderDetailsList = By.id("order-detail-content");
    private By deleteProductButton = By.xpath(".//*[contains(@class,'cart_quantity_delete')]");
    private By productNameDetailsList = By.xpath(".//*[contains(@class,'cart_item')]//td/p");
    private By emptyCartAlert = By.xpath("//*[@id=\'center_column\']/p");

    public void waitVisibilityOfOrderStepBar(){

        waitVisibilityOf(orderStepsBar);
    }

    public int getOrderDetailsListCounter(){

        return findElements(orderDetailsList).size();
    }

    public void deleteSpecificProductFromCart(){
        clicOnSpecificAddToCartOption(orderDetailsList,deleteProductButton,getOrderDetailsListCounter()-1);
    }

    public String getProductNameToDelete(){
        return getText(productNameDetailsList);
    }

    public void waitTextPresentInElement(){
        waitTextPresentInElement(emptyCartAlert,"Your shopping cart is empty.");
    }

    public boolean isEmptyCardAlertDisplayed(){
        return isElementDisplayed(emptyCartAlert);
    }
}
