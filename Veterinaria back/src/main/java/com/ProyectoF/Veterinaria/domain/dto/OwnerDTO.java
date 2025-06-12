package com.ProyectoF.Veterinaria.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OwnerDTO {

    Long id;
    String name;
    String email;
    String phone;
    String address;
    String city;
}
