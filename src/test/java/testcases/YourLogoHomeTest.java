package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YourLogoHomeTest extends BaseTest{

    @Test
    public void addingItemToShoppingCartTest(){

        String productNameToAddCart = "";
        String productNameAddedCart = "";

        yourLogoHomePage.setCriteriaToSearch("dress");//TODO this value could be retrieve from a file or Data Base
        yourLogoHomePage.pressEnterKeyBarField();
        yourLogoHomePage.waitUntilCounterItemAppear();
        yourLogoHomePage.selectViewType(2);//TODO this value could be retrieve from a properties file
        yourLogoHomePage.clicOnAddToCartButton();
        yourLogoHomePage.waitLayerProductAddedSuccessfullyAppear();
        //
        Assert.assertEquals(
                yourLogoHomePage.getProductNameToAddCart(),
                yourLogoHomePage.getProductNameAddedCart(),
                "Product to add to cart isn't the same product added cart");

    }
}
