package com.ashim.web.crawler.core;

import java.io.IOException;
import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ashim.web.crawler.api.CrawlerRepository;
import com.ashim.web.crawler.api.DomainLinkConverter;
import com.ashim.web.crawler.api.WebConnector;
import com.ashim.web.crawler.api.WebPageReader;
import com.ashim.web.crawler.util.PropertiesReader;

/**
 * Crawl the Web
 *
 */
public class WebCrawlerApp 
{
	private static final Logger logger = LoggerFactory.getLogger(WebCrawlerApp.class);
	
    public static void main( String[] args )
    {
               
        PropertiesReader propReader =  PropertiesReader.getInstance();
        WebConnector webConnector = new WebHttpConnectorImpl();
    	WebPageReader pageReader = new WebPageReaderImpl();
    	DomainLinkConverter domainConverter = new DomainLinkConverterImpl();
    	CrawlerRepository crawlerRepository = new CrawlerRepositoryImpl();
        
    	String domainUrl = null;
        
        try {
			 domainUrl = propReader.getPropertyByValue("url");
		} catch (IOException e) {
			logger.warn("Could not find domain URL " + e.getMessage());
			
		}
        
        logger.info(domainUrl);
        
        WebCrawlerBot webBot = new WebCrawlerBot(webConnector, pageReader, domainConverter, crawlerRepository, domainUrl);
        
        try {
			webBot.crawlWeb();
		} catch (MalformedURLException e) {
			logger.warn("Invlid Url " + e.getMessage());
		} catch (IOException e) {
			logger.warn("IO problems " + e.getMessage());
		}
        
        
        
    }
}
