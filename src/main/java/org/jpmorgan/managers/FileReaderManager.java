package org.jpmorgan.managers;

import org.jpmorgan.dataprovider.ConfigFileReader;


public class FileReaderManager {

    private static final FileReaderManager fileReaderManager = new FileReaderManager();

    private ConfigFileReader configFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigReader() {

        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }


}
