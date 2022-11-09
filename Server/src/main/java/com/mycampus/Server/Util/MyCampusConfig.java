package com.mycampus.Server.Util;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.MyCampusConfigProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class MyCampusConfig {
    private static Logger MCLogger = LogManager.getLogger(MyCampusConfig.class);

    @PostConstruct
    public void init(){
        loadProperties();
    }

    private void loadProperties(){
        String methodName = "loadProperties";
        MCLogger.info(methodName+" Loading Properties");
        try {
            InputStream propertiesInputStream = new FileInputStream(MyCampusConst.PROPERTIES_FILE_PATH);
            Properties properties = new Properties();
            properties.load(propertiesInputStream);
            new MyCampusConfigProperties(properties);
        }
        catch (Exception e){
            MCLogger.error(methodName+" Exception while loading properties file",e);
        }
    }
}
