package com.shopping.cart.util;

public class Helper {

   static ReadAppProperties readAppProperties = new ReadAppProperties();
    public static String getAppBase() {
        return readAppProperties.readKey("application.properties", "URL");
    }

    public static String getBrowser() {
        return readAppProperties.readKey("application.properties", "BROWSER");
    }

    public static String getUserName() {
        return readAppProperties.readKey("application.properties", "USERNAME");
    }

    public static String getPassword() {
        return readAppProperties.readKey("application.properties", "PASSWORD");
    }
}
