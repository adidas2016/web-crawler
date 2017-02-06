package com.ashim.web.crawler.core;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ashim.web.crawler.api.DomainLinkConverter;

public class DomainLinkConverterImpl implements DomainLinkConverter {
	
	private static final Logger logger = LoggerFactory.getLogger(DomainLinkConverterImpl.class);
	
	private static final String FILTER_PATTERN = "<a href=(\\S+)";
	
	@Override
	public List<String> convertHtmlPageToSubDomainsAsLink(String htmlPage) {
		
		  Pattern pattenUrl = Pattern.compile(FILTER_PATTERN);
          Matcher matchUrl = pattenUrl.matcher(htmlPage);
        
          List<String> urlList = new ArrayList<String>();
        
         // print all the matches that we find
         while (matchUrl.find())
         {
          urlList.add(matchUrl.group(1));  
          
         }
         
         logger.info("Found No of Sub domain Url +" +urlList.size());
         
         List<String> subDomainList = urlList.stream()
         		.map(str -> str.substring(1, str.indexOf("\"", 2)))
         		.collect(Collectors.toList());
         
		 return subDomainList;
	}

}
