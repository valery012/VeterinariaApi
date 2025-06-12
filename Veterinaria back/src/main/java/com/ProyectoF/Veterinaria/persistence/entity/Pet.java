package com.ProyectoF.Veterinaria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String species;
    String breed;
    String medicalHistory;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner owner;

    @OneToMany(mappedBy = "pet",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> Appointments = new ArrayList<>();


}
