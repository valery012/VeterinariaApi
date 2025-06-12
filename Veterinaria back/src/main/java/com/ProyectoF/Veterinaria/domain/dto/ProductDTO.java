package com.ProyectoF.Veterinaria.domain.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    Long id;
    Long amount;
    String name;
    String description;
    String company;
    Date expirationDate;
    Long price;
}
