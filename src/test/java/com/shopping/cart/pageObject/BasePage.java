package com.shopping.cart.pageObject;

import com.shopping.cart.util.WebdriverHelper;
import com.shopping.cart.stepDefinitions.BaseDriver;
import com.shopping.cart.util.ReadAppProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

	private String pageUrl;
	private WebDriver driver;
	private WebdriverHelper webdriverHelper;


	BasePage(String pageUrl) {
		this.pageUrl = pageUrl;
		this.driver = new BaseDriver().setUpDriver();
		this.webdriverHelper = new WebdriverHelper(driver);
		PageFactory.initElements(driver, this);
	}

	WebdriverHelper getActions() {
		return webdriverHelper;
	}

	@Override
	public void load() {
		if (pageUrl.contains("http")) {
			driver.get(pageUrl);
		} else {
			driver.get(getAppUrl() + pageUrl);
		}
	}

	@Override
	protected void isLoaded() throws Error {
		if (!this.driver.getCurrentUrl().contains(pageUrl) && getActions().isPageReady()) {
			throw new Error(webdriverHelper.getCurrentUrl() + " is not loaded");
		}
	}

	protected String getAppUrl() {
			ReadAppProperties readAppProperties = new ReadAppProperties();
			return readAppProperties.readKey("application.properties", "URL");
		}
	}

