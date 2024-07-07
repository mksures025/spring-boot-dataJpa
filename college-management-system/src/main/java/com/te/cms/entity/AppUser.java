package com.te.cms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "appUser_tb")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appUSer_id")
    private Integer appUserId;

    @Column(name = "user_name")
    private String UserName;

    private String password;

    @JoinTable(name = "app_user_tb_role_tb" ,joinColumns = {@JoinColumn(name = "app_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @ManyToMany(cascade = CascadeType.ALL)
     private Set<Role> roles;
}
