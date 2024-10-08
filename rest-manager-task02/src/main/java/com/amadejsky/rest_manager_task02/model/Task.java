package com.amadejsky.rest_manager_task02.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@Table(name="TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String tytul;
    protected String opis;
    protected String status;
    protected LocalDate termin;
    @ManyToMany
    protected List<User> przypisaniUzytkonicy;
}