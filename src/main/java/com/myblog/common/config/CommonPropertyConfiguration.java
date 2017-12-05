package com.myblog.common.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class CommonPropertyConfiguration {
	
	private String layout;
	private String fullLayout;
	
	private Map<String, String> templates;

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getFullLayout() {
		return fullLayout;
	}

	public void setFullLayout(String fullLayout) {
		this.fullLayout = fullLayout;
	}

	public Map<String, String> getTemplates() {
		return templates;
	}

	public void setTemplates(Map<String, String> templates) {
		this.templates = templates;
	}

	 
	
}
