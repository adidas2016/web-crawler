package com.ashim.web.crawler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mock;

import com.ashim.web.crawler.api.CrawlerRepository;
import com.ashim.web.crawler.api.DomainLinkConverter;
import com.ashim.web.crawler.api.WebCrawlerConnector;
import com.ashim.web.crawler.api.WebPageReader;

/**
 * Unit test for Web Crawler App.
 */
public class WebCrawlerTest {
	
	@Mock
	WebPageReader webCrawler;
    
	@Mock
	WebCrawlerConnector webConnector;
	@Mock
	DomainLinkConverter linkConverter;
	@Mock
	CrawlerRepository crawlRepository;
	
	@Test
	public void given_an_url_should_return_html_page(){
		assertTrue(true);
		
	}
	
	@Test
    public void given_an_invald_url_should_return_empty_html_page(){
		
	}
    
}
