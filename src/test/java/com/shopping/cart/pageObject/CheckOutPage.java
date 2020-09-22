package com.shopping.cart.pageObject;

import com.shopping.cart.util.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage<CheckOutPage> {
	@FindBy(css = "[href*='order&step=1']")
	private WebElement proceedToStep2;

	@FindBy(css = "[name='processAddress']")
	private WebElement proceedToStep4;

	@FindBy(css = "[name='processCarrier']")
	private WebElement proceedToStep5;

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

	public boolean purchase() {
		getActions().click(proceedToStep2);
		getActions().inputText(emailField, Helper.getUserName());
		getActions().inputText(passwordField, Helper.getPassword());
		getActions().click(signInButton);
		getActions().click(proceedToStep4);
		getActions().click(termsOfServiceCheckobx);
		getActions().click(proceedToStep5);
		getActions().click(payBankWire);
		getActions().click(completeOrder);
		return successMessage.getText().contains("is complete");
	}
}
