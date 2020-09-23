package com.shopping.cart.pageObject;

import com.shopping.cart.util.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage<CheckOutPage> {
	@FindBy(css = "[href*='order&step=1']")
	private WebElement proceedToSignIn;

	@FindBy(css = "[name='processAddress']")
	private WebElement proceedToAddressDetails;

	@FindBy(css = "[name='processCarrier']")
	private WebElement proceedToCarrierDetails;

	@FindBy(className = "checker")
	private WebElement termsOfServiceCheckobx;

	@FindBy(className = "bankwire")
	private WebElement payBankWire;

	@FindBy(css = "#cart_navigation > button")
	private WebElement completeOrder;

	@FindBy(css = "#center_column > div")
	private WebElement successMessage;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "passwd")
	private WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	private WebElement signInButton;

	public CheckOutPage() {
		super("index.php?controller=order");
	}

	public void proceedToPurchase() {
		getActions().click(proceedToSignIn);
	}

	public boolean isPurchaseComplete() {
		return successMessage.getText().contains("is complete");
	}

	public void completesPaymentdetailAndPurchase() {
		getActions().click(proceedToAddressDetails);
		getActions().click(termsOfServiceCheckobx);
		getActions().click(proceedToCarrierDetails);
		getActions().click(payBankWire);
		getActions().click(completeOrder);
	}

	public void signIn() {
		getActions().inputText(emailField, Helper.getUserName());
		getActions().inputText(passwordField, Helper.getPassword());
		getActions().click(signInButton);
	}
}
