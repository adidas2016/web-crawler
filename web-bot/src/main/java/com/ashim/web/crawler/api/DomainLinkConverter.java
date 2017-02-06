package com.ashim.web.crawler.api;

import java.util.List;

public interface DomainLinkConverter {
	
	public List<String> convertHtmlPageToSubDomainsAsLink(String htmlPage);

}
