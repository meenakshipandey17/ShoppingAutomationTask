package com.shopping.cart.stepDefinitions;

import com.shopping.cart.pageObject.SignInPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class SignInStepDef{

    SignInPage signInPage = new SignInPage().get();

    @Given("^user is on signIn page$")
    public void userIsOnSignInPage() {
        Assert.assertTrue(signInPage.isSignInLinkDisplayed());
    }

    @Then("^user is logged in$")
    public void signIn() throws Throwable {
        signInPage.signInWithCredentials("meena@xyz.com", "test1234");
        Assert.assertTrue(signInPage.isSignOutLinkDisplayed());
    }
}
