package com.shopping.cart.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadAppProperties {

    ClassLoader objClassLoader = null;
    Properties commonProperties = new Properties();


    public ReadAppProperties() {
        objClassLoader = getClass().getClassLoader();
    }

    public String readKey(String propertiesFilename, String key) {
        if (propertiesFilename != null && !propertiesFilename.trim().isEmpty()
                && key != null && !key.trim().isEmpty()) {
            try (
                    FileInputStream objFileInputStream = new FileInputStream(objClassLoader.getResource(propertiesFilename).getFile());
            ) {
                commonProperties.load(objFileInputStream);
                return String.valueOf(commonProperties.get(key));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}