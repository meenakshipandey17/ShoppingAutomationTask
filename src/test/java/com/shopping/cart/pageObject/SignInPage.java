package com.shopping.cart.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage<SignInPage> {
	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "passwd")
	private WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	private WebElement signInButton;

	@FindBy(className = "logout")
	private WebElement signOutLink;

	@FindBy(className = "login")
	private WebElement signInLink;

	public SignInPage() {
		super("index.php?controller=authentication&back=my-account");
	}

	public void signInWithCredentials(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		getActions().click(signInButton);
	}

	public boolean isSignInLinkDisplayed() {
		return getActions().isElementDisplayed(signInButton);
	}

	public boolean isSignOutLinkDisplayed() {
		return getActions().isElementDisplayed(signOutLink);
	}

}