package com.ProyectoF.Veterinaria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
@Entity
@Getter @Setter
@NoArgsConstructor
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String phone;
    String email;
    String specialty;
    LocalDate entry_date;
    String state;
    String password;

    @OneToMany(mappedBy = "veterinarian",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> Appointments = new ArrayList<>();
}
