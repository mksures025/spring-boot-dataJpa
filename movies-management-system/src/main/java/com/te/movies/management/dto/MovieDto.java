package com.te.movies.management.dto;

import java.util.List;

import com.te.movies.management.system.enums.Industry;
import com.te.movies.management.system.enums.Studio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
 @Builder
public class MovieDto {

	private String title;
	private Double imdpRating;
	private String industry;
	private String studio;
	private Integer releaseYear;
	private List<LanguageDTO> language;
	private List<ActorsDTO> actors;
	private FinancialDTO financials;

}
