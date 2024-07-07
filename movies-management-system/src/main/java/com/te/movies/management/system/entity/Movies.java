package com.te.movies.management.system.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.JdbcTypeRegistration;

import com.te.movies.management.system.enums.Industry;
import com.te.movies.management.system.enums.Studio;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name="movies")

public class Movies {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="movie_id")
	private Integer movieId;
	
	private String title;
	
	@Column(name="imdp_rating")
	private Double imdpRating;
	
	@Column(name="release_year")
	private Integer releaseYear;
	
	
	private String industry;
	
	
	private String studio;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Language> language;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Actors> actors;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Financials financials;
	

}
