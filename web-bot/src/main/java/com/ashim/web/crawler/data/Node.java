package com.ashim.web.crawler.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents individual node of the node tree.
 */

public class Node {
	
	 private String pageTitle;
	 
	 private String pageUrl;
	 
	 private final List<Node> children = new ArrayList<>();
	 private final Node parent;
	 
	 public Node(Node parent) {
	       this.parent = parent;
	 }
	 
	 public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public List<Node> getChildren() {
	      return children;
	 }
	 
	 public Node getParent() {
	      return parent;
	 }
}