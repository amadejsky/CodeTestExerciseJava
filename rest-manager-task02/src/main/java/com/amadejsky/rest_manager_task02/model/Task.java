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
    protected Status status;
    protected LocalDate termin;
    @ManyToMany(fetch = FetchType.EAGER)
    protected List<User> przypisaniUzytkonicy;

    public enum Status{
        AKTYWNE,
        ZAKONCZONE,
        ANULOWANE,
        ZAMKNIETE
    }
}
