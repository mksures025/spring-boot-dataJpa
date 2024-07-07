package com.te.cms.dto;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AdminDTO {
    private String adminId;
    private String adminName;
    private String email;
    private String gender;
}
