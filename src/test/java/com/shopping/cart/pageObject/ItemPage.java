package com.shopping.cart.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage<ItemPage> {
	@FindBy(className = "login")
	private WebElement headerSignInLink;

	@FindBy(css = "p#add_to_cart > button > span")
	private WebElement addToCartButton;

	@FindBy(css = "a[title='Proceed to checkout']")
	private WebElement proceedToCheckoutButton;

	public ItemPage() {
		super("index.php?id_product=5&controller=product");
	}

	public void clickAddToCart() {
		getActions().click(addToCartButton);
		getActions().isElementDisplayed(proceedToCheckoutButton);
	}

	public CheckOutPage clickCheckout() {
		getActions().click(proceedToCheckoutButton);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.isLoaded();
		return new CheckOutPage();
	}

	public boolean isSignInLinkDisplayed() {
		return getActions().isElementDisplayed(headerSignInLink);
	}

}
