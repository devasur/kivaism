package org.kiva.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image{
	String id;
	String templateId;
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	@JsonProperty("template_id")
	public String getTemplateId() {
		return templateId;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
}