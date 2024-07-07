package com.te.movies.management.system.repository;

import com.te.movies.management.system.entity.Movies;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void findByindustryOrderByImdpRatingDesc() {

        List<Movies> actualResult =
                movieRepository.findByindustryOrderByImdpRatingDesc("Bollywood");

        assertEquals("Bollywood",actualResult.get(0).getIndustry());

    }
}