package ru.pavel2107.arch.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;

    @Column( name = "email")
    private String email;

    @Column( name = "password")
    private String password;

    @Column( name = "fio")
    private String fio;

    @Column( name = "phone")
    private String phone;

    @Column( name = "active")
    private Boolean active;

    @Column( name = "role")
    private String role;

    @OneToMany( mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

    private String address;
}
