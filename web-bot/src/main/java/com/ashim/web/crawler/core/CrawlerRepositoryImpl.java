package com.ashim.web.crawler.core;

import java.util.List;

import com.ashim.web.crawler.api.CrawlerRepository;
import com.ashim.web.crawler.data.Node;
import com.ashim.web.crawler.data.SiteMapRepositoryManager;


public class CrawlerRepositoryImpl implements CrawlerRepository{
	
	private String domainUrl;
	
	private Node lastSavedChildNode;
	
	public CrawlerRepositoryImpl(String domainUrl){
		 this.domainUrl = domainUrl;
	}
	
	private SiteMapRepositoryManager siteMapRepository = SiteMapRepositoryManager.getInstance(domainUrl);
	
	@Override
	public void saveCrawledLinks(List<String> urlLinks) {
	 
         saveLastChildNode(siteMapRepository.saveCrawledUrlLinks(urlLinks));
		
	}
	
	private synchronized void saveLastChildNode(Node childNode){
		 lastSavedChildNode = childNode;
	}
	
	@Override
	public List<String> getLinksToCrawl(Node node) {
		 return siteMapRepository.getUrlsToCrawl(node);
	}

}
