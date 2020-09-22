package com.shopping.cart.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.util.function.Function;


public class WebdriverHelper {

	private final WebDriver driver;
	static final Integer DEFAULT_TIMEOUT = Integer.parseInt(System.getProperty("selenium.defaultTimeout", "5"));

	public WebdriverHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		click(element, DEFAULT_TIMEOUT);
	}

	void click(WebElement element, Integer timeout) {
		isElementDisplayed(element, timeout);
		element.click();
	}

	public boolean isElementDisplayed(WebElement element) {
		return isElementDisplayed(element, DEFAULT_TIMEOUT);
	}

	public boolean isElementNotDisplayed(WebElement element) {
		return isElementNotDisplayed(element, DEFAULT_TIMEOUT);
	}

	public boolean isTextChanged(WebElement element, String originalText) {
		return isTextChanged(element, originalText, DEFAULT_TIMEOUT);
	}

	void inputText(WebElement element, String text, Integer timeout) {
		isElementDisplayed(element, timeout);
		element.sendKeys(text);
	}

	public void inputText(WebElement element, String text) {
		inputText(element, text, DEFAULT_TIMEOUT);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}

	public Actions hover() {
		return new org.openqa.selenium.interactions.Actions(driver);
	}

	public boolean isPageReady() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
			wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		} catch (WebDriverException e) {
			return false;
		}
		return true;
	}

	public boolean isElementTextChanged(WebElement element, String originalText) {
		return isElementTextChanged(element, originalText, DEFAULT_TIMEOUT);
	}

	private boolean isElementDisplayed(WebElement element, Integer timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	private boolean isElementNotDisplayed(WebElement element, Integer timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (TimeoutException e) {
			return false;
		}
		return true;
	}

	private boolean isTextChanged(WebElement element, String originalText, Integer timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(new Function<WebDriver, Boolean>() {
				String initialText = originalText;

				public Boolean apply(WebDriver driver) {
					return !element.getText().equals(initialText);
				}
			});
		} catch (WebDriverException e) {
			return false;
		}
		return true;
	}

	private boolean isElementTextChanged(WebElement element, String originalText, Integer timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(new Function<WebDriver, Boolean>() {
				String initialText = originalText;

				public Boolean apply(WebDriver driver) {
					return !element.getText().equals(initialText);
				}
			});
		} catch (WebDriverException e) {
			return false;
		}
		return true;
	}


}
