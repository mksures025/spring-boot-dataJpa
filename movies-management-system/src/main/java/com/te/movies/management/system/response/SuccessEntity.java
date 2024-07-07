package com.te.movies.management.system.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

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
public class SuccessEntity {
	
	private String message;
	private Object data;
	private HttpStatus Status;
	private LocalDateTime timeStamp;
	

}
