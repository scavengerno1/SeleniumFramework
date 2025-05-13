package part2.org.saucedemo.tests.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.org.saucedemo.tests.base.BaseTests;

public class LoginTest extends BaseTests {

    @Test
    public void testLoginErrorMessage() throws InterruptedException {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauc");
        var productsPage = loginPage.clickLoginButton();
        String actualMessage = "Epic sadface: Username is required";
        Assert.assertTrue(actualMessage.contains("Epic sadface"));

    }


}
