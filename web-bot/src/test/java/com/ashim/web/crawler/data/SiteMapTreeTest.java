package com.ashim.web.crawler.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


public class SiteMapTreeTest {
	
	private String url = "www.yourhtmlsource.com";
	private SiteMapTree  siteMap;
	private Node rootNode; 
	private Node childNode;
	
	@Before
	public void setUp(){
		
        siteMap = SiteMapTree.getInstance(url);
		rootNode = siteMap.getSiteRootNode();
	    childNode = siteMap.addChild(rootNode, "page-1", url+"/about");
		siteMap.addChild(childNode,"page-11",url+"/faq");
		siteMap.addChild(childNode,"page-12",url+"/help");
		
		Node childNode2 = siteMap.addChild(rootNode, "page-2", url+"/services");
		siteMap.addChild(childNode2,"page-21",url+"/contact");
		
	}
	
	@Test
	public void given_a_site_map_verify_site_map_tree_contents(){
		

		assertTrue(siteMap.printTree(rootNode, "").contains(url +"/contact"));
		
	}
	
	@Test
	public void given_a_tree_node_should_get_correct_child_nodes(){
		
		List<Node> childNodes = siteMap.getChildNodesFromParentNode(childNode, true); 
		
		assertTrue(childNodes.size() == 2);
		
	}
		

}
