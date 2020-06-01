/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ramenrecipes.bean;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author gliss
 */
public class PropertiesBean {

    public String getProp(String key) {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("config.properties");
            Properties properties  = new Properties();
            properties.load(is);
            return properties.getProperty(key);
        } catch (Exception e) {
            return "No value is set";
        }

    }
}
