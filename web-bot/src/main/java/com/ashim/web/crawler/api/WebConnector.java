package com.ashim.web.crawler.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public interface WebConnector {
	
	public HttpURLConnection getHttpConnectionFromUrl(String httpUrl) throws MalformedURLException, IOException;
	
	public String getDomainNameFromUrl(String httpUrl) throws MalformedURLException;
	
	public void setHttpURLConnection(HttpURLConnection httpURLConnection);

}
