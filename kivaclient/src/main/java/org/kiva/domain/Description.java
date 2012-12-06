package org.kiva.domain;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Description{
	List<String> languages;
	Map<String,String> texts;
	@JsonProperty("languages")
	public List<String> getLanguages() {
		return languages;
	}
	@JsonProperty("texts")
	public Map<String, String> getTexts() {
		return texts;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public void setTexts(Map<String, String> texts) {
		this.texts = texts;
	}
	
}