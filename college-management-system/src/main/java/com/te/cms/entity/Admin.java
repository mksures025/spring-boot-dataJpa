package com.te.cms.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "admin_tb")
public class Admin {

    @Id
    @Column(name = "admin_Id")
    private String adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "admin_email")
    private String email;
    private String gender;
}
