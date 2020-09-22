package com.shopping.cart.stepDefinitions;

import com.shopping.cart.util.ReadAppProperties;
import cucumber.api.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory{

	public static WebDriver driver;

	public WebDriver setUpDriver() {
		return getDriver();
	}

	private WebDriver getDriver() {
		if (getBrowser().equals("CHROME")) {
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

	private String getBrowser() {
		ReadAppProperties readAppProperties = new ReadAppProperties();
		return readAppProperties.readKey("application.properties", "BROWSER");
	}




}