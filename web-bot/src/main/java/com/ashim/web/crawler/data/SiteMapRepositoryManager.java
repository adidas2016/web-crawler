package com.ashim.web.crawler.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SiteMapRepositoryManager {

	private String domainUrl;
	
	private static SiteMapTree siteMap ;
	
    private SiteMapRepositoryManager(){
	}
		
	private static class LazyHolder {
         private static final SiteMapRepositoryManager INSTANCE = new SiteMapRepositoryManager();
    }

    public synchronized static SiteMapRepositoryManager getInstance(String domainUrl) {
    	 
    	 LazyHolder.INSTANCE.domainUrl = domainUrl;
    	 siteMap = SiteMapTree.getInstance(domainUrl);
         
    	 return LazyHolder.INSTANCE;
    }
    
    public synchronized Node saveCrawledUrlLinks(List<String> links){

    	 int pageCounter = 0;
    	 Node rootNode = siteMap.getSiteRootNode();
    	 Node childNode = null;
    	
    	 for(String url : links ){
    		 pageCounter ++;
    		 childNode = siteMap.addChild(rootNode, "page- " + pageCounter, url);
    	 }
    	 
    	 siteMap.printTree(getRootNode(), "");
    	 
		 return childNode;
    }
    
    public List<String> getUrlsToCrawl(Node node){
         
    	 if (node == null){ 
        	 node = getRootNode();
         }
    	 List<String> links = new ArrayList<String>();
         List<Node> crawlNodes = siteMap.getChildNodesFromParentNode(node, true);
        
         links = crawlNodes.stream().map(nd -> nd.getPageUrl()).collect(Collectors.toList());
        
         return links;
    }
    
    public Node getRootNode(){
    	
    	 return siteMap.getSiteRootNode();
    }
    
}