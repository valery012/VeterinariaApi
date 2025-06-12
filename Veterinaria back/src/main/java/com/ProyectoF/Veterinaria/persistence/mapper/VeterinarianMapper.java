package com.ProyectoF.Veterinaria.persistence.mapper;
import com.ProyectoF.Veterinaria.domain.dto.VeterinarianDTO;
import com.ProyectoF.Veterinaria.persistence.entity.Veterinarian;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeterinarianMapper {


    VeterinarianDTO toDto(Veterinarian veterinarian);

    Veterinarian toEntity(VeterinarianDTO veterinarianDTO);
}
