package com.te.movies.management.system.servicetest;

import com.te.movies.management.dto.MovieDto;
import com.te.movies.management.system.entity.Movies;
import com.te.movies.management.system.repository.MovieRepository;
import com.te.movies.management.system.service.MovieServiceimpl;
import com.te.movies.management.system.service.MoviesService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceTest{

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceimpl moviesService;

  /*  public void setUp(){

        MockitoAnnotations.openMocks(this);
        this.moviesService=new MoviesService(movieRepository);
    }
*/
    @Test
    public void saveDataTest(){

        MovieDto movieDto=new MovieDto();
        movieDto.setTitle("KGF");

        Movies  movies =new Movies();
        movies.setTitle("KGF");

       when(movieRepository.save(any(Movies.class))).thenReturn(movies);

        String movieData = moviesService.saveData(movieDto);

        verify(movieRepository).save(any(Movies.class));

        assertEquals("KGF", movieData);


    }

    @Test
    void fetchByBollywood() {

         movieRepository.findByindustryOrderByImdpRatingDesc("Bollywood");

        verify(movieRepository).findByindustryOrderByImdpRatingDesc("Bollywood");
    }


}
