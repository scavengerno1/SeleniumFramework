package part2.org.saucedemo.tests.tests.product;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.org.saucedemo.tests.base.BaseTests;

public class ProductsTests extends BaseTests {

    @Test
    public void productLogin() throws InterruptedException {
        var productsPage = loginPage.logInToApplication("standard_user", "secret_sauce");

        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e){
            System.out.println("No element");
        }

        boolean isProductsDisplayed = productsPage.isProductsHeaderDisplayer();
        Assert.assertTrue(isProductsDisplayed);

    }


}
