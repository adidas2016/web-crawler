package com.ashim.web.crawler.api;

import java.util.List;

import com.ashim.web.crawler.data.Node;

public interface CrawlerRepository {
	
	public void saveCrawledLinks(List<String> urlLinks);
	
	public List<String> getLinksToCrawl(Node nodeIdentifier);

}
