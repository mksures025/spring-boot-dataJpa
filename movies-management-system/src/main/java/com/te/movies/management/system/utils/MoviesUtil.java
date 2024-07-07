package com.te.movies.management.system.utils;

import com.te.movies.management.dto.MovieDto;
import com.te.movies.management.system.entity.Movies;

public class MoviesUtil {

	public static Movies ConvertDtotoEntity(MovieDto movieDto) {

    Movies movies = Movies.builder()
    .title(movieDto.getTitle())
    .imdpRating(movieDto.getImdpRating())
    .industry(movieDto.getIndustry())
    .studio(movieDto.getStudio())
    .language(null)
    .actors(null)
    .build();
    
		
		return movies;
	}

}
