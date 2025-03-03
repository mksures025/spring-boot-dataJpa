package com.te.cms.dto;

import com.te.cms.dto.StudentRegisterDTO.StudentRegisterDTOBuilder;
import com.te.cms.entity.AddressType;
import com.te.cms.entity.Student;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressDTO {
	
    private Integer addressId;
    private String city;
    private String state;
    private AddressType addressType;
    private StudentRegisterDTO student;


}
