package com.te.movies.management.dto;

import java.util.List;


import com.te.movies.management.system.enums.LanguageName;

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
public class LanguageDTO {
	
	private String languageName;
	
	private List<MovieDto> movies;

}
