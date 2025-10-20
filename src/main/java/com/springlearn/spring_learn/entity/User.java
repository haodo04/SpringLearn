package com.springlearn.spring_learn.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username", unique = true, columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
    String username;

    String password;

    @NotBlank(message = "firstname must be not blank")
    String firstName;

    @NotBlank(message = "lastname must be not blank")
    String lastName;

    @NotBlank(message = "dob must be not blank")
    LocalDate dob;

    @ManyToMany
    Set<Role> roles;

}
