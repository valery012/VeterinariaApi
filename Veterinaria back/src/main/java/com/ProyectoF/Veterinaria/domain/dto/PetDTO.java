package com.ProyectoF.Veterinaria.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PetDTO {
    Long id;
    String name;
    String species;
    String breed;
    Long ownerId;
    String medicalHistory;

}
