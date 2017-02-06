package com.ashim.web.crawler.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ashim.web.crawler.api.CrawlerRepository;
import com.ashim.web.crawler.api.DomainLinkConverter;
import com.ashim.web.crawler.api.WebConnector;
import com.ashim.web.crawler.api.WebPageReader;

public class WebCrawlerBot {
	
	private static final Logger logger = LoggerFactory.getLogger(WebCrawlerBot.class);
	
	private WebConnector webConnector;
	private WebPageReader pageReader;
	private DomainLinkConverter domainConverter;
	private CrawlerRepository crawlerRepository;
	
	private String domainUrl;
	
	public WebCrawlerBot(WebConnector webConnector, WebPageReader pageReader, 
			   DomainLinkConverter domainConverter, CrawlerRepository crawlerRepository, String domainUrl) {
		
		
		this.webConnector = webConnector;
		this.pageReader = pageReader;
		this.domainConverter = domainConverter;
		this.crawlerRepository = crawlerRepository;
		this.domainUrl = domainUrl;
		
	}
	
	public void crawlWeb()  throws MalformedURLException, IOException{
		
		HttpURLConnection httpConnection = webConnector.getHttpConnectionFromUrl(domainUrl);
		
		String htmlPage= pageReader.getHtmlPageFromUrlConnection(httpConnection);
		
		List<String> subDomainUrls = domainConverter.convertHtmlPageToSubDomainsAsLink(htmlPage);
		
		subDomainUrls.forEach(System.out::println);
//		crawlerRepository.saveCrawledLinks(subDomainUrls);
		
	}

	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}
	
	

}
