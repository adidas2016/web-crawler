package com.ashim.web.crawler.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ashim.web.crawler.core.WebCrawlerBot;


public class SiteMapTree {
	
	private static final Logger logger = LoggerFactory.getLogger(SiteMapTree.class);
	
	private Node siteRootNode;
	
	private static final String ROOT_NODE = "ROOT";
	
	private StringBuilder siteMapBuilder = new StringBuilder();
	
	private List<Node> childNodes = new ArrayList<Node>();
	
	private SiteMapTree(){
		   siteRootNode = new Node(null);
		   siteRootNode.setPageTitle(ROOT_NODE);
		   siteRootNode.setPageUrl(null);
	}
		
	private static class LazyHolder {
           private static final SiteMapTree INSTANCE = new SiteMapTree();
    }
 
    public synchronized static SiteMapTree getInstance(String domainUrl) {
    	   LazyHolder.INSTANCE.siteRootNode.setPageUrl(domainUrl);
           return LazyHolder.INSTANCE;
    }

	public Node addChild(Node parent, String pageTitle, String pageUrl){
		
		   Node node = new Node(parent);
		   node.setPageTitle(pageTitle);
		   node.setPageUrl(pageUrl);
		   parent.getChildren().add(node);
		   return node;
	}
	
	public String printTree(Node node, String appender) {
          
		   if(node.getPageTitle().equals(ROOT_NODE) ) {
		      siteMapBuilder = new StringBuilder(); 
		   }   

		   siteMapBuilder.append(" : " + appender + node.getPageTitle() + " , " + node.getPageUrl());
		   logger.info(" : " + appender + node.getPageTitle() + " , " + node.getPageUrl());		 
		   for (Node each : node.getChildren()) {
		      printTree(each, appender + appender);
		      
		   }
		   return siteMapBuilder.toString();
		 
	}

	public Node getSiteRootNode() {
		return siteRootNode;
	}
	
	public List<Node> getChildNodesFromParentNode(Node parentNode, boolean firstIter){
		
		if(firstIter){
		   childNodes.clear();
		}
		for (Node each : parentNode.getChildren()) {
			childNodes.add(each);		      
			getChildNodesFromParentNode(each, false);  
		}
		
		return childNodes;
		
	}
	
	
}
