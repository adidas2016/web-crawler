package com.ashim.web.crawler.core;

import java.net.HttpURLConnection;
import java.util.List;

import com.ashim.web.crawler.api.CrawlerRepository;
import com.ashim.web.crawler.api.DomainLinkConverter;
import com.ashim.web.crawler.api.WebCrawlerConnector;
import com.ashim.web.crawler.api.WebPageReader;

public class WebCrawlerBot {
	
	private WebCrawlerConnector webConnector;
	private WebPageReader pageReader;
	private DomainLinkConverter domainConverter;
	private CrawlerRepository crawlerRepository;
	
	private String domainUrl;
	
	public WebCrawlerBot(WebCrawlerConnector webConnector, WebPageReader pageReader, 
			   DomainLinkConverter domainConverter, CrawlerRepository crawlerRepository, String domainUrl) {
		
		
		this.webConnector = webConnector;
		this.pageReader = pageReader;
		this.domainConverter = domainConverter;
		this.crawlerRepository = crawlerRepository;
		this.domainUrl = domainUrl;
		
	}
	
	public void crawlWeb(){
		
		HttpURLConnection httpConnection = webConnector.getHttpConnectionFromUrl(domainUrl);
		String htmlPage = pageReader.getHtmlPageFromUrlConnection(httpConnection);
		List<String> subDomainUrls = domainConverter.convertHtmlPageToSubDomainsAsLink(htmlPage);
		
		crawlerRepository.saveCrawledLinks(subDomainUrls);
		
	}

	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}
	
	

}
