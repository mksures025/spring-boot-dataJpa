package com.te.movies.management.system.service;

import java.util.List;

import com.te.movies.management.dto.MovieDto;
import com.te.movies.management.system.entity.Movies;

public interface MoviesService {

	String saveData(MovieDto movieDto);

	List<Movies> fetchByBollywood(String industryName);

	List<Movies> fetchByIndustry(String industryName,int limit);

	List<Movies> fetchByIndustryFromEntry(String industryName, Integer limit);

	List<Movies> fetchByMoviesOrderByReleaseYear(Movies movies);

	List<Movies> fetchByStudio(String[] studios);


	List<Movies> fetchAllMovies();

	List<Movies> fetchById(Integer id);
}
