package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import pages.YourLogoHomePage;

public class ShoppingCartTest extends BaseTest{

    @Parameters({"productToSearch"})
    @Test
    public void removeItemShoppingCart(String productToSearch)  {

        String productToDelete = "";
        String productAddedCart = "";
        YourLogoHomePage yourLogoHomePage =
                PageFactory.initElements(driver,
                        YourLogoHomePage.class);
        //first, we add an item into the cart
        yourLogoHomePage.setCriteriaToSearch(productToSearch);
        yourLogoHomePage.pressEnterKeyBarField();
        yourLogoHomePage.waitUntilCounterItemAppear();
        yourLogoHomePage.selectViewType(2);//TODO this value could be retrieve from a properties file
        yourLogoHomePage.clicOnAddToCartButton();
        yourLogoHomePage.waitLayerProductAddedSuccessfullyAppear();
        //
        productAddedCart = yourLogoHomePage.getProductNameAddedCart();
        Assert.assertEquals(
                yourLogoHomePage.getProductNameToAddCart(),
                yourLogoHomePage.getProductNameAddedCart(),
                "Product to add to cart isn't the same product added cart");

        yourLogoHomePage.closeLayerProductAddedSuccessfully();
        yourLogoHomePage.waitLayerProductAddedSuccessfullyDisappear();
        yourLogoHomePage.clicShoppingCartOption();

        ShoppingCartPage shoppingCartPage =
                PageFactory.initElements(driver,
                ShoppingCartPage.class);

        shoppingCartPage.waitVisibilityOfOrderStepBar();
        productToDelete = shoppingCartPage.getProductNameToDelete();
        shoppingCartPage.deleteSpecificProductFromCart();
        shoppingCartPage.waitTextPresentInElement();
        //
        Assert.assertTrue(shoppingCartPage.isEmptyCardAlertDisplayed(),"Shopping Cart is not empty");
        //
        Assert.assertEquals(productAddedCart,productToDelete,"Product to delete is different to product added");
    }
}
