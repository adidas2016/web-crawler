package com.ashim.web.crawler.api;

import java.util.List;

public interface CrawlerRepository {
	
	public void saveCrawledLinks(List<String> urlLinks);
	
	public List<String> getLinksToCrawl(String nodeIdentifier);

}
