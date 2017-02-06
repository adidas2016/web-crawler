package com.ashim.web.crawler.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ashim.web.crawler.api.WebConnector;


public class WebHttpConnectorImpl implements WebConnector{
	
	private static final Logger logger = LoggerFactory.getLogger(WebHttpConnectorImpl.class);
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String HTTP_PROTOCOL = "http://";
	
	private HttpURLConnection httpURLConnection = null;
	
	@Override
	public HttpURLConnection getHttpConnectionFromUrl(String httpUrl) throws MalformedURLException, IOException {
		
		if (!validateUrl(httpUrl)) throw  new IllegalArgumentException();
		
		
		URL httpConnectionObject = new URL(httpUrl);
		httpURLConnection = (HttpURLConnection) httpConnectionObject.openConnection();
		httpURLConnection.setRequestMethod("GET");

		//add request header TODO set time out
		httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = httpURLConnection.getResponseCode();
		logger.info("Response Code : " + responseCode);
		
		
		return httpURLConnection;
		
	}
	
	
	@Override
	public String getDomainNameFromUrl(String httpUrl) throws MalformedURLException {
		
		URL domainURL =  new URL(httpUrl);
	    String hostName = domainURL.getHost();
        logger.info("Domain URL " + domainURL);
	
        return hostName;
	}
	
	
	private boolean validateUrl(String httpUrl){
		if(null == httpUrl) return false;
		if (httpUrl.startsWith(HTTP_PROTOCOL)) {
			return true;
		}
		return false;
		
	}
	
	public void setHttpURLConnection(HttpURLConnection httpURLConnection) {
		this.httpURLConnection = httpURLConnection;
	}

}
