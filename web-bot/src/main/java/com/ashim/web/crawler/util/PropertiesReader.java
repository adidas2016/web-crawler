package com.ashim.web.crawler.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesReader {
	
	private PropertiesReader(){}
	
	private static class LazyHolder {
        private static final PropertiesReader INSTANCE = new PropertiesReader();
    }
 
    public static PropertiesReader getInstance() {
        return LazyHolder.INSTANCE;
    }
	
	private String crawlUrl = "";
	private InputStream inputStream;
	private static final String PROPERTY_FILE_NAME="config.properties";
	
	private static final Logger logger = LoggerFactory.getLogger(PropertiesReader.class);
	
	public String getPropertyByValue(String key) throws IOException {
		
	try {
		 Properties prop = new Properties();
			 
		 inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
			
 		 if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + PROPERTY_FILE_NAME + "' not found in the classpath");
		  }
 			
 		 crawlUrl = prop.getProperty("url");
 			
		} catch (IOException e) {
			logger.warn("Failed to Read Proerties InputStream " + e.getMessage());
		} finally {
			inputStream.close();
		}
		
		return crawlUrl;
	}
}