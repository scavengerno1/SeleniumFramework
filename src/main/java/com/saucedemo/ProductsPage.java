package com.saucedemo;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage{

    private By productsHeader = By.xpath("//div[text()='Products']");

    public boolean isProductsHeaderDisplayer(){
        return find(productsHeader).isDisplayed();
    }


}
