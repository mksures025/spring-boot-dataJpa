package com.te.movies.management.system.enums;

public enum Industry {
	
	BOLLYWOOD("BOLLYWOOD"),HOLLYWOOD("HOLLYWOOD");
	
	private String industry;

	private Industry(String industry) {
		this.industry = industry;
	}

	public String getIndustry() {
		return industry;
	}

}
