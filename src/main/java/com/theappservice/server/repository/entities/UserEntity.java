package com.theappservice.server.repository.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "user_name", unique = true)
    @Size(min = 1, max = 100)
    private String userName;

    @NotBlank
    @Column(name = "first_name")
    @Size(max = 50)
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 50)
    private String lastName;
}
