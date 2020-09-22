package com.shopping.cart.stepDefinitions;

import com.shopping.cart.pageObject.CheckOutPage;
import com.shopping.cart.pageObject.ItemPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static org.testng.Assert.assertEquals;

public class ItemStepDef {

    ItemPage itemPage = new ItemPage().get();

    private String SUMMER_DRESS_PAGE_TITLE = "Printed Summer Dress - My Store";

    @Given("^user is on selected dress page$")
    public void userNavigateToSummerDressStorePage() {
       assertEquals(itemPage.getPageTitle(), SUMMER_DRESS_PAGE_TITLE);
    }

    @And("^add selected dress to cart$")
    public void addTheDressToCart() {
        itemPage.clickAddToCart();
    }

    @And("^proceed to checkout and purchase the item$")
    public void proceedToCheckout() {
        CheckOutPage checkOutPage = itemPage.clickCheckout();
        checkOutPage.purchase();
    }

    @Given("^user is not logged in$")
    public void userIsNotLoggedIn() {
        itemPage.isSignInLinkDisplayed();
    }
}
