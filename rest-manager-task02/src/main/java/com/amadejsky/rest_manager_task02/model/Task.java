package com.amadejsky.rest_manager_task02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    protected String tytul;
    @NotBlank
    protected String opis;
    @NotNull
    protected Status status;
    @NotNull
    @FutureOrPresent
    protected LocalDate termin;
    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    protected List<User> przypisaniUzytkonicy;

    public enum Status{
        AKTYWNE,
        ZAKONCZONE,
        ANULOWANE,
        ZAMKNIETE
    }
}
