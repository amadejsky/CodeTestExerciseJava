package com.amadejsky.rest_manager_task02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    protected String imie;
    @NotBlank
    protected String nazwisko;
    @NotBlank
    protected String email;

}
