package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YourLogoHomePage;

public class YourLogoHomeTest extends BaseTest{

    @Test
    public void addingItemToShoppingCartTest(){

        YourLogoHomePage yourLogoHomePage =
                PageFactory.initElements(driver,
                        YourLogoHomePage.class);

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

        yourLogoHomePage.closeLayerProductAddedSuccessfully();
        //TODO: return to home page
    }

    @Test
    public void searchingForProductExisting(){

        YourLogoHomePage yourLogoHomePage =
                PageFactory.initElements(driver,
                        YourLogoHomePage.class);

        yourLogoHomePage.setCriteriaToSearch("short");//TODO this value could be retrieve from a file or Data Base
        yourLogoHomePage.pressEnterKeyBarField();
        yourLogoHomePage.waitUntilCounterItemAppear();

        Assert.assertTrue(yourLogoHomePage.wereProductsFound(),
                            "Product(s) wasn't/weren't found!");
    }

    @Test
    public void searchingForProductDoesntExisting(){

        YourLogoHomePage yourLogoHomePage =
                PageFactory.initElements(driver,
                        YourLogoHomePage.class);

        yourLogoHomePage.setCriteriaToSearch("camisa");//TODO this value could be retrieve from a file or Data Base
        yourLogoHomePage.pressEnterKeyBarField();
        yourLogoHomePage.waitTextPresentInElement();

        Assert.assertFalse(yourLogoHomePage.wereProductsFound(),
                "Product(s) was/were found!");
    }

    @Test
    public void validateStoreInformations() {

        //values against test
        String storeAddress = "Selenium Framework, Research Triangle Park, North Carolina, USA";
        String storePhoneNumber = "(347) 466-7432";
        String storeEmail = "support@seleniumframework.com";

        YourLogoHomePage yourLogoHomePage =
                PageFactory.initElements(driver,
                        YourLogoHomePage.class);

        yourLogoHomePage.scrollDownUntilStoreInformationBlock();

        Assert.assertTrue(yourLogoHomePage.AreValidStoreInformations(storeAddress,
                                                                    storePhoneNumber,
                                                                    storeEmail),
                        "The store information are different as expected");
    }

}
