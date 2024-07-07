package com.te.movies.management.system.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.movies.management.dto.ActorsDTO;
import com.te.movies.management.dto.FinancialDTO;
import com.te.movies.management.dto.LanguageDTO;
import com.te.movies.management.dto.MovieDto;
import com.te.movies.management.system.entity.Actors;
import com.te.movies.management.system.entity.Movies;
import com.te.movies.management.system.response.SuccessEntity;
import com.te.movies.management.system.service.MoviesService;
import com.te.movies.management.system.utils.MoviesUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/app/movie")
@RestController
@Slf4j
public class MovieApplicationController {
/*
	FileHandler fileHandler;

    {
        try {
            fileHandler = new FileHandler("mk.log",true);
			fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
*/

	/*

InputStream inputStream = MovieApplicationController.class.getResourceAsStream("/logging.properties");
	try {
		LogManager.getLogManager().readConfiguration(inputStream);
*/
        private final MoviesService movieService;

	@GetMapping(path = "displaydata")
	public ResponseEntity<SuccessEntity> displayDto() {

    log.info("display method entered");


		MovieDto movieDto = MovieDto.builder().industry(null).imdpRating(0.0).title("").studio("").releaseYear(0)
				.actors(List.of(ActorsDTO.builder().actorName("").birthYear(0).build()))
				.language(List.of(LanguageDTO.builder().languageName("").build()))
				.financials(FinancialDTO.builder().budget(0.0).currencyType("").revenue(0.0).units("").build()).build();

		log.debug("data genrated"+movieDto);
		return ResponseEntity.ok().body(SuccessEntity.builder().message("Movies Detail for Display").data(movieDto)
				.Status(HttpStatus.OK).build());
	}

	// 1. Insert movie data in the database with related data.

	@PostMapping(path = "savedata")
	public ResponseEntity<SuccessEntity> savaData(@RequestBody MovieDto movieDto) {
		System.out.println(movieDto.getTitle());
		System.out.println(movieDto.getStudio());

		String MovieName = movieService.saveData(movieDto);

		return ResponseEntity.ok().body(
				SuccessEntity.builder().message("Movies Data saved").data(MovieName).Status(HttpStatus.OK).build());
	}

	/*
	 * 2. Write a SQL query to retrieve all Bollywood movies, ordering them by IMDb
	 * rating in descending order.
	 */

	@GetMapping(path = "{industryName}")
	public SuccessEntity fetchDataByBollywoodInDesc(@PathVariable String industryName) {

		List<Movies> MovieName = movieService.fetchByBollywood(industryName);

		/*
		 * return ResponseEntity.ok().body(
		 * SuccessEntity.builder().message("Bollywood Movies data").data(MovieName).
		 * Status(HttpStatus.OK).build());
		 */
		return SuccessEntity.builder().message("Bollywood Movies data").data(MovieName).
				 Status(HttpStatus.OK).build();
	}

	/*
	 * 3. Can you create a SQL query to select the top 5 Bollywood/Hollywood
	 * (Dynamic Input) movies with the lowest IMDb ratings, ordered in ascending
	 * order?
	 */

	@GetMapping(path = "industries/{industryName}/{limits}")
	public ResponseEntity<SuccessEntity> fetchDataByIndustry(@PathVariable String industryName,@PathVariable int limits) {

		List<Movies> MovieName = movieService.fetchByIndustry(industryName,limits);

		return ResponseEntity.ok().body(SuccessEntity.builder().message(" industry based data Movies Detail")
				.data(MovieName).Status(HttpStatus.OK).build());
	}

	/*
	 * 4. Write a SQL query to display the top 5 Bollywood/Hollywood (Dynamic Input)
	 * movies with the highest IMDb ratings, starting from the third (Dynamic Input)
	 * entry.
	 */

	@GetMapping(path = "industry/{industryName}/{limit}")
	public ResponseEntity<SuccessEntity> fetchDataIndustryFromEntry(@PathVariable String industryName,
			@PathVariable Integer limit) {

		List<Movies> MovieName = movieService.fetchByIndustryFromEntry(industryName, limit);

		return ResponseEntity.ok().body(SuccessEntity.builder().message(" industry based data Movies Detail")
				.data(MovieName).Status(HttpStatus.OK).build());
	}

	/*
	 * 5. How can you select movies produced by "Studio Name 1", "Studio Name 2",
	 * "Studio Name 3" (Number of studio names can be variable) using a SQL query?
	 */
	@GetMapping(path = "studio")
	public ResponseEntity<SuccessEntity> fetchDataIndustryUsingDynamicEntry(@RequestParam String... studios) {

		List<Movies> MoviesDetail = movieService.fetchByStudio(studios);

		return ResponseEntity.ok().body(SuccessEntity.builder().message(" Studio based  Movies Detail")
				.data(MoviesDetail).Status(HttpStatus.OK).build());
	}

	/*
	 * 6.How would you write a SQL query to list all movies, ordered by their
	 * release year in descending order?
	 */

	@GetMapping(path = "allmovies")
	public ResponseEntity<SuccessEntity> fetchDataByMoviesinDesc() {
		
		Movies movies=new Movies();

		List<Movies> MovieName = movieService.fetchByMoviesOrderByReleaseYear(movies);

		return ResponseEntity.ok().body(SuccessEntity.builder().message(" Movie List By Desc using release year")
				.data(MovieName).Status(HttpStatus.OK).build());
	}
	
	/*7. Create a SQL query to select all movies with "Certain set of characters example 'THOR'"
	() in their title, ordered by release year in descending order.
	 */

	// Stored Procedure


	@GetMapping(path = "getAllMovies")
	public List<Movies> getAllMovies(){

		List<Movies> movieList=movieService.fetchAllMovies();
		return movieList ;
	}
	@GetMapping(path = "getMoviesById/{id}")
	public List<Movies> getMovies(@PathVariable Integer id){

		List<Movies> movieList=movieService.fetchById(id);
		return movieList ;
	}

}
