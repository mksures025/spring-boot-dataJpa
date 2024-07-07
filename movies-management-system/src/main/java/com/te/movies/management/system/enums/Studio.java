package com.te.movies.management.system.enums;

public enum Studio {
	
	HombaleFilms("Hombale Films"),MarvelStudios("Marvel Studios")
	,UnitedProducers("United Producers"),YashRajFilms("Yash Raj Films"),
	VinodChopraFilms("Vinod Chopra Films"),UniversalPictures ("Universal Pictures " );
	
	private String studio;

	private Studio(String studio) {
		this.studio = studio;
	}

	public String getStudio() {
		return studio;
	}


}
