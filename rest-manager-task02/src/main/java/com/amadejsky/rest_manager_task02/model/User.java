package com.amadejsky.rest_manager_task02.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String imie;
    protected String nazisko;
    protected String email;

}
