package com.ashim.web.crawler.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

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
	
	//Example : http://www.yourhtmlsource.com/myfirstsite/
	private String domainUrl;
	
	//Example : www.yourhtmlsource.com
	private String domainMainHost;
	
	private static final String HTTP_PROTOCOL = "http://";
	
	public WebCrawlerBot(WebConnector webConnector, WebPageReader pageReader, 
			   DomainLinkConverter domainConverter, CrawlerRepository crawlerRepository, String domainUrl, String domainMainHost) {
		
		
		 this.webConnector = webConnector;
		 this.pageReader = pageReader;
		 this.domainConverter = domainConverter;
		 this.crawlerRepository = crawlerRepository;
		 this.domainUrl = domainUrl;
		 this.domainMainHost = domainMainHost;
		
	}
	
	//TODO run this in parallel recursively 
	public void goCrawlTheWeb()  throws MalformedURLException, IOException{
		
		 List<String> subDomainUrls = connectToDomainAndGetNestedUrls(domainUrl);
		 
		 List<String> cleanDomainUrls;
		 
		 logger.info("Raw Urls from Connect Domain >>" + domainUrl);
		 subDomainUrls.forEach(System.out::println);
		 cleanDomainUrls = subDomainUrls.stream().map(url -> sanitizeUrl(url)).collect(Collectors.toList());
		 
		 logger.info("Cleaned  >> Urls from Connect Domain  " + domainUrl);
		 cleanDomainUrls.forEach(System.out::println);
		
		 crawlerRepository.saveCrawledLinks(cleanDomainUrls);
		
	}

	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}
	
	//TODO need to enrich this with pattern matchers
    private String sanitizeUrl(String url){
		StringBuilder cleanUrl = new StringBuilder();
    	if(url.startsWith("/")){
    		cleanUrl.append(HTTP_PROTOCOL).append(domainMainHost).append(url);
    		return cleanUrl.toString();
    	}
    	return url;
    }
    
    private List<String> connectToDomainAndGetNestedUrls(String domainUrl) throws MalformedURLException, IOException{
    	
    	 HttpURLConnection httpConnection = webConnector.getHttpConnectionFromUrl(domainUrl);
		 String htmlPage= pageReader.getHtmlPageFromUrlConnection(httpConnection);
		 List<String> domainUrls = domainConverter.convertHtmlPageToSubDomainsAsLink(htmlPage);
    	
		 return domainUrls;
    }

}
