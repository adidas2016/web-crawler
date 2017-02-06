package com.ashim.web.crawler.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ashim.web.crawler.api.WebPageReader;

public class WebPageReaderImpl implements WebPageReader{
	
	private static final Logger logger = LoggerFactory.getLogger(WebPageReaderImpl.class);
	
	@Override
	public String getHtmlPageFromUrlConnection(HttpURLConnection urlConnection) throws IOException{
		
			String inputLine;
			StringBuffer siteResponse = new StringBuffer();
			BufferedReader htmlinputReader = null;
		
			
	        htmlinputReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			while ((inputLine = htmlinputReader.readLine()) != null) {
				siteResponse.append(inputLine);
			}
			htmlinputReader.close();
			urlConnection.disconnect();
		
		    return siteResponse.toString();
	}

}
