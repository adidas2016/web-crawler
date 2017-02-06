package com.ashim.web.crawler.api;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface WebPageReader {
	
	public String getHtmlPageFromUrlConnection(HttpURLConnection httpConnection) throws IOException ;

}
