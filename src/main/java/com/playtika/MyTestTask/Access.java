package com.playtika.MyTestTask;

import twitter4j.conf.ConfigurationBuilder;

public class Access {

    private Access() {
    }

    private static volatile Access instance;

    private static APPConfig appConfig;

    public static Access getInstance(){
        if (instance==null){
            synchronized (Access.class){
                if (instance==null){
                    appConfig = new APPConfig();
                    return new Access();
                }
            }
        }
        return instance;
    }

    private ConfigurationBuilder accessToTwitterApp(){

        return new ConfigurationBuilder().
                setDebugEnabled(true).
                setOAuthConsumerKey(appConfig.getConfigApp("ConsumerKey")).
                setOAuthConsumerSecret(appConfig.getConfigApp("ConsumerSecret")).
                setOAuthAccessToken(appConfig.getConfigApp("AccessToken")).
                setOAuthAccessTokenSecret(appConfig.getConfigApp("AccessTokenSecret"));
    }

    public ConfigurationBuilder getAccessToTwitterApp(){
        return accessToTwitterApp();
    }

}
