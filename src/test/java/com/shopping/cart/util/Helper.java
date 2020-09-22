package com.shopping.cart.util;

public class Helper {

    public static String getAppUrl() {
        ReadAppProperties readAppProperties = new ReadAppProperties();
        return readAppProperties.readKey("application.properties", "URL");
    }

    public static String getBrowser() {
        ReadAppProperties readAppProperties = new ReadAppProperties();
        return readAppProperties.readKey("application.properties", "BROWSER");
    }

    public static String getUserName() {
        ReadAppProperties readAppProperties = new ReadAppProperties();
        return readAppProperties.readKey("application.properties", "USERNAME");
    }

    public static String getPassword() {
        ReadAppProperties readAppProperties = new ReadAppProperties();
        return readAppProperties.readKey("application.properties", "PASSWORD");
    }
}
