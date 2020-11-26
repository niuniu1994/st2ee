/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efrei.st2ee.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author louis
 */
public class PropertiesUtils {

    public Properties getDBPropertiesFile() {
        Properties prop = null;

        try {
            prop = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("database.properties");
            prop.load(input);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return prop;
    }
}
