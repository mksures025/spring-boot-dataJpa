package com.te.movies.management.system.repository;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.te.movies.management.system.entity.Movies;
import org.springframework.data.jpa.repository.query.Procedure;

public interface MovieRepository extends JpaRepository<Movies, Integer> {

	List<Movies> findByindustryOrderByImdpRatingAsc(String industryName, PageRequest pageRequest);

	List<Movies> findByindustryOrderByImdpRatingDesc(String industryName);

	List<Movies> findByStudioIn(String[] studios);
	
//	@Query("Select m from Movies m where industry = ?1 ORDER BY m.imdpRating DESC")
//	List<Movies> findTopFiveIndustry(String industryName,PageRequest pageRequest);

	List<Movies> findByindustryOrderByImdpRatingDesc(String industryName, PageRequest pageRequest);


	List<Movies> findAllByOrderByReleaseYearDesc(PageRequest pageRequest);


	//stored procedure


	@Procedure(value = "getAllMovies")
	List<Movies> fetchAllMovies();

	@Procedure(value = "getAllData")
	List<Movies> fetchById(Integer id);
}
