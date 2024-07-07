package com.te.movies.management.system.service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.te.movies.management.dto.MovieDto;
import com.te.movies.management.system.entity.Movies;
import com.te.movies.management.system.repository.MovieRepository;
import com.te.movies.management.system.utils.MoviesUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieServiceimpl implements MoviesService {

    private final MovieRepository movieRepository;


    @Override
    public String saveData(MovieDto movieDto) {

        Movies movies = MoviesUtil.ConvertDtotoEntity(movieDto);

        Movies moviess = movieRepository.save(movies);

        return movies.getTitle();
    }

    /*
     * 2. Write a SQL query to retrieve all Bollywood movies, ordering them by IMDb
     * rating in descending order.
     */

    @Override
    public List<Movies> fetchByBollywood(String industryName) {

        List<Movies> movies = movieRepository.findByindustryOrderByImdpRatingDesc(industryName);

        return movies;
    }

    /*
     * 3. Can you create a SQL query to select the top 5 Bollywood/Hollywood
     * (Dynamic Input) movies with the lowest IMDb ratings, ordered in ascending
     * order?
     */

    @Override
    public List<Movies> fetchByIndustry(String industryName, int limit) {


        PageRequest pageRequest = PageRequest.of(0, limit);

        List<Movies> movies = movieRepository.findByindustryOrderByImdpRatingAsc(industryName, pageRequest);


        return movies;

    }

    /*
     * 4. Write a SQL query to display the top 5 Bollywood/Hollywood (Dynamic Input)
     * movies with the highest IMDb ratings, starting from the third (Dynamic Input)
     * entry.
     */

    @Override
    public List<Movies> fetchByIndustryFromEntry(String industryName, Integer limit) {

        PageRequest pageRequest = PageRequest.of(2, limit);

        List<Movies> movies = movieRepository.findByindustryOrderByImdpRatingDesc(industryName, pageRequest);

        return movies;
    }

    /*
     * 5. How can you select movies produced by "Studio Name 1", "Studio Name 2",
     * "Studio Name 3" (Number of studio names can be variable) using a SQL query?
     */

    @Override
    public List<Movies> fetchByStudio(String[] studios) {

        List<Movies> movies = movieRepository.findByStudioIn(studios);

        return movies;
    }

    /*
     * 6.How would you write a SQL query to list all movies, ordered by their
     * release year in descending order?
     */
    @Override
    public List<Movies> fetchByMoviesOrderByReleaseYear(Movies movies) {

        PageRequest pageRequest = PageRequest.of(3, 5);
        List<Movies> movie = movieRepository.findAllByOrderByReleaseYearDesc(pageRequest);


        return movie;
    }

    @Override
    @Transactional
    public List<Movies> fetchAllMovies() {
        List<Movies> movies = movieRepository.fetchAllMovies();
        return movies;
    }

    @Override
    @Transactional
    public List<Movies> fetchById(Integer id) {
        List<Movies> movies = movieRepository.fetchById(id);
        return movies;
    }
}
