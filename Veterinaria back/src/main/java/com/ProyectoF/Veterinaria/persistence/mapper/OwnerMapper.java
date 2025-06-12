package com.ProyectoF.Veterinaria.persistence.mapper;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.domain.dto.OwnerDTO;
import com.ProyectoF.Veterinaria.persistence.entity.Appointment;
import com.ProyectoF.Veterinaria.persistence.entity.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerDTO toDto(Owner owner);

    Owner toEntity(OwnerDTO ownerDTO);
}
