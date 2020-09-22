package com.shopping.cart.stepDefinitions;

import com.shopping.cart.util.Helper;
import com.shopping.cart.util.ReadAppProperties;
import cucumber.api.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {

	public static WebDriver driver;

	public WebDriver setUpDriver() {
		if(driver == null) {
			driver = getDriver();
		}
		return driver;
	}

	private WebDriver getDriver() {
		if (Helper.getBrowser().equals("CHROME")) {
			ChromeDriverManager.chromedriver().setup();
			driver =  new ChromeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		return driver;
	}

	@After
	public void closeDriver(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}






}