package com.te.cms.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SuccessResponse {

    private String message;
    private Object data;
    private HttpStatus status;
    private LocalDateTime timestamp;
}
