package com.ashim.web.crawler.api;

import java.net.HttpURLConnection;

public interface WebCrawlerConnector {
	
	public HttpURLConnection getHttpConnectionFromUrl(String httpUrl);
	
	public String getDomainNameFromUrl(String httpUrl);

}
