package com.te.movies.management.system.enums;

public enum LanguageName {
	
	
	BENGALI("Bengali"),TAMIL("Tamil"),ENGLISH("English"),
	FRENCH("French"),HINDI("Hindi"),KANNADA("Kannada"),
	TELUGU("TELUGU");
	
	private String languageName;

	private LanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLanguageName() {
		return languageName;
	}

	

}
