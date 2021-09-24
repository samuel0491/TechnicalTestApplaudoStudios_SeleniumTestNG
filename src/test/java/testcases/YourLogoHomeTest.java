package testcases;

import org.testng.annotations.Test;

public class YourLogoHomeTest extends BaseTest{

    @Test
    public void addingItemToShoppingCartTest(){

        yourLogoHomePage.setCriteriaToSearch("dress");//TODO this value could be retrieve from a file or Data Base
        yourLogoHomePage.pressEnterKeyBarField();
        yourLogoHomePage.waitUntilCounterItemAppear();
    }
}
