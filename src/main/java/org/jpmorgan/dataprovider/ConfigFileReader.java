package org.jpmorgan.dataprovider;

import org.jpmorgan.constants.FrameworkConstants;
import org.jpmorgan.exceptions.FrameworkExceptions;
import org.jpmorgan.exceptions.PropertyFileUsageException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;


    public ConfigFileReader() {
        final String propertyFilePath = FrameworkConstants.getCONFIGFILEPATH();
        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            properties = new Properties();
            properties.load(reader);

        } catch (IOException e) {
            e.printStackTrace();
            throw new PropertyFileUsageException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getURL() {
        String url = properties.getProperty("url");

        if (Objects.nonNull(url)) return url;
        else throw new FrameworkExceptions("url not specified in Configuration.properties file");
    }

}
