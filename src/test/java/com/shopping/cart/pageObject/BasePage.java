package com.shopping.cart.pageObject;

import com.shopping.cart.util.Helper;
import com.shopping.cart.util.ActionHelper;
import com.shopping.cart.stepDefinitions.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

	private String pageUrl;
	private WebDriver driver;
	private ActionHelper actionHelper;


	BasePage(String pageUrl) {
		this.pageUrl = pageUrl;
		this.driver = new BaseDriver().setUpDriver();
		this.actionHelper = new ActionHelper(driver);
		PageFactory.initElements(driver, this);
	}

	ActionHelper getActions() {
		return actionHelper;
	}

	@Override
	public void load() {
		if (pageUrl.contains("http")) {
			driver.get(pageUrl);
		} else {
			driver.get(Helper.getAppUrl() + pageUrl);
		}
	}

	@Override
	protected void isLoaded() throws Error {
		if (!this.driver.getCurrentUrl().contains(pageUrl) && getActions().isPageReady()) {
			throw new Error(actionHelper.getCurrentUrl() + " is not loading");
		}
	}

	 public String getPageTitle(){
		return driver.getTitle();
	 }

	}

