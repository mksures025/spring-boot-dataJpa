package com.te.movies.management.dto;

import java.util.List;

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
public class ActorsDTO {
	
	private String actorName;
	private Integer birthYear;
	
	private List<MovieDto> movies;

}
