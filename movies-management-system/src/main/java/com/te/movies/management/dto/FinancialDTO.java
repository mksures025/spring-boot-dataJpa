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
public class FinancialDTO {
	
	private Double budget;
	private Double revenue;
	private String units;
	private String currencyType;

}
