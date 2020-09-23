package com.shopping.cart.stepDefinitions;

import com.shopping.cart.pageObject.CheckOutPage;
import com.shopping.cart.pageObject.ItemPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static org.testng.Assert.assertEquals;

public class ItemStepDef {

    ItemPage itemPage = new ItemPage().get();
    CheckOutPage checkOutPage;

    private String SUMMER_DRESS_PAGE_TITLE = "Printed Summer Dress - My Store";

    @Given("^user is on selected dress page$")
    public void userNavigateToSummerDressStorePage() {
       assertEquals(itemPage.getPageTitle(), SUMMER_DRESS_PAGE_TITLE);
    }

    @And("^add dress to cart$")
    public void addTheDressToCart() {
        itemPage.clickAddToCart();
    }

    @And("^proceed to checkout$")
    public void proceedToCheckout() {
        checkOutPage =  itemPage.clickCheckout();
        checkOutPage.proceedToPurchase();
    }
    @Given("^user is not logged in$")
    public void userIsNotLoggedIn() {
        itemPage.isSignInLinkDisplayed();
    }

    @And("^user is prompted to signIn$")
    public void userIsPresentedWithSignInScreen() {
        checkOutPage.signIn();
    }

    @And("^After signing in user proceeded with payment details$")
    public void userSignedInAndPurchasedTheDress() {
        checkOutPage.completesPaymentdetailAndPurchase();
    }

    @And("^user completes the purchase with success$")
    public void userIsPresentedWithSuccessScreen() {
        checkOutPage.isPurchaseComplete();
    }
}
