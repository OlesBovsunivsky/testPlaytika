package com.playtika.MyTestTask;


import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * This class get config to access in twitter app
 */
public class APPConfig {


    private static final String REFERENCE_FILE_OF_CONFIG = "src/main/resources/config.properties";

    private static final Logger LOGGER = Logger.getLogger(APPConfig.class);

    private FileInputStream fileInputStream;
    private Properties property = new Properties();
    private Map<String, String> accoutConfig = new HashMap<>();

    /**
     * Method of reading options for file access
     * @return the map of config to access in twitter app
     */
    private Map<String, String> configApp() {

        try {
            fileInputStream = new FileInputStream(REFERENCE_FILE_OF_CONFIG);
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        }

        try {
            property.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error(e);
        }

        accoutConfig.put("ConsumerKey", property.getProperty("twitter.consumerKey"));
        accoutConfig.put("ConsumerSecret", property.getProperty("twitter.ConsumerSecret"));
        accoutConfig.put("AccessToken", property.getProperty("twitter.AccessToken"));
        accoutConfig.put("AccessTokenSecret", property.getProperty("twitter.AccessTokenSecret"));

        return accoutConfig;

    }

    public String getConfigApp(String nameConfig) {
        return accoutConfig.isEmpty() ? configApp().get(nameConfig) : accoutConfig.get(nameConfig);
    }


}
