package com.ProyectoF.Veterinaria.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@Getter @Setter
@NoArgsConstructor
public class AppointmentDTO {
    Long id;
    String description;
    Long petId;
    Long veterinarianId;
    Date datee;
}
