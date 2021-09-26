package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.YourLogoHomePage;

public class YourLogoHomeTest extends BaseTest{

    @Parameters({"productToSearch"})
    @Test
    public void addingItemToShoppingCartTest(String productToSearch){

        YourLogoHomePage yourLogoHomePage =
                PageFactory.initElements(driver,
                        YourLogoHomePage.class);

        yourLogoHomePage.setCriteriaToSearch(productToSearch);//
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

        yourLogoHomePage.closeLayerProductAddedSuccessfully();
        //TODO: return to home page
    }

    @Parameters({"productToSearch"})
    @Test
    public void searchingForProductExisting(String productToSearch){

        YourLogoHomePage yourLogoHomePage =
                PageFactory.initElements(driver,
                        YourLogoHomePage.class);

        yourLogoHomePage.setCriteriaToSearch(productToSearch);//
        yourLogoHomePage.pressEnterKeyBarField();
        yourLogoHomePage.waitUntilCounterItemAppear();

        Assert.assertTrue(yourLogoHomePage.wereProductsFound(),
                            "Product(s) wasn't/weren't found!");
    }

    @Parameters({"productToSearch"})
    @Test
    public void searchingForProductDoesntExisting(String productToSearch){

        YourLogoHomePage yourLogoHomePage =
                PageFactory.initElements(driver,
                        YourLogoHomePage.class);

        yourLogoHomePage.setCriteriaToSearch(productToSearch);//
        yourLogoHomePage.pressEnterKeyBarField();
        yourLogoHomePage.waitTextPresentInElement();

        Assert.assertFalse(yourLogoHomePage.wereProductsFound(),
                "Product(s) was/were found!");
    }

    @Parameters({"storeAddress","storePhoneNumber","storeEmail"})
    @Test
    public void validateStoreInformation(String storeAddress, String storePhoneNumber, String storeEmail) {
        YourLogoHomePage yourLogoHomePage =
                PageFactory.initElements(driver,
                        YourLogoHomePage.class);

        yourLogoHomePage.scrollDownUntilStoreInformationBlock();

        Assert.assertTrue(yourLogoHomePage.AreValidStoreInformation(storeAddress,
                                                                    storePhoneNumber,
                                                                    storeEmail),
                        "The store information are different as expected");
    }

}
