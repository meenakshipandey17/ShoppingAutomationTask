package com.shopping.cart.stepDefinitions;

import com.shopping.cart.util.Helper;
import cucumber.api.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {
	private final static Logger logger = Logger.getLogger(BaseDriver.class);
	public static WebDriver driver;

	public WebDriver setUpDriver() {
		String browserType = Helper.getBrowser();

		if(driver == null) {
			driver = getDriver(browserType);
        }
		return driver;
	}

	private WebDriver getDriver(String browserType){
		switch (browserType) {
			case "FIREFOX":
				getFirefoxDriver();
				break;
			case "CHROME":
				ChromeDriverManager.chromedriver().setup();
				driver =  new ChromeDriver();
				break;
			default:
				logger.info("Browser value: " + browserType + " is invalid, Launching Firefox by default");
				driver = getFirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	private WebDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	@After
	public void closeDriver(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}






}