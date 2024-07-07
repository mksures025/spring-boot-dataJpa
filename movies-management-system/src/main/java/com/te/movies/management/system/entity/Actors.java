package com.te.movies.management.system.entity;

import java.time.LocalDate;
import java.util.List;

import com.te.movies.management.system.enums.Industry;
import com.te.movies.management.system.enums.Studio;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name="actors")
public class Actors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="actor_id")
	private int actorId;
	
	@Column(name="actor_name")
	private String actorName;
	@Column(name="birth_year")
	
	private Integer birthYear;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "actors")
	private List<Movies> movies;


}
