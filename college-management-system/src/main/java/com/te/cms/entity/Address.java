package com.te.cms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.te.cms.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@JsonIgnoreProperties
public class Address {

    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    @Id
    private Integer addressId;

    private String city;
    private String state;

    @Enumerated(EnumType.STRING)
    private AddressType  addressType;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="stu_fk")
    private Student student;
}
