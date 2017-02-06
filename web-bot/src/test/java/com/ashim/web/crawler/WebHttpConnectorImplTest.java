package com.ashim.web.crawler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ashim.web.crawler.api.WebConnector;
import com.ashim.web.crawler.core.WebHttpConnectorImpl;



@RunWith(MockitoJUnitRunner.class)
public class WebHttpConnectorImplTest {
	
	private WebConnector systemUnderTest;
	
	@Mock
	WebConnector webConnector;
	
	@InjectMocks 
	WebHttpConnectorImpl httpConnectorImpl = new WebHttpConnectorImpl();
	

	
	@Test
	public void given_a_valid_url_should_return_valid_connection_code() throws MalformedURLException, IOException{
		
//		when(webConnector.getHttpConnectionFromUrl("htpp//google.com")).thenReturn(new HttpURLConnection());
		
		
	}
	
	@Test
	public void given_a_valid_url_should_return_domain_name() throws MalformedURLException{
		String url = "http://www.yourhtmlsource.com/myfirstsite/";
		WebHttpConnectorImpl systemUnderTest = new WebHttpConnectorImpl();
		 
		String urlDomain = systemUnderTest.getDomainNameFromUrl(url);
	
		assertTrue(urlDomain.equals("www.yourhtmlsource.com"));
		 
	}

}
