package com.redoz.onclassuser.infrastructure.driven.jpa.mysql.entity;

import com.redoz.onclassuser.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    private String documentNumber;

    private String name;

    private String email;

    private String lastName;

    @Column(length = 10)
    private String telephone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String password;

}
