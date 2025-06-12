package com.ProyectoF.Veterinaria.persistence.mapper;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.persistence.entity.Appointment;

import com.ProyectoF.Veterinaria.persistence.entity.Owner;
import com.ProyectoF.Veterinaria.persistence.entity.Pet;
import com.ProyectoF.Veterinaria.persistence.entity.Veterinarian;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "pet.id", target = "petId")
    @Mapping(source = "veterinarian.id", target = "veterinarianId")
    AppointmentDTO toDto(Appointment appointment);

    @Mapping(target = "pet" , source = "petId")
    @Mapping(target = "veterinarian" , source = "veterinarianId")
    Appointment toEntity(AppointmentDTO appointmentDTO);

    default Pet mapPetIdToPet(Long petId){
        if(petId == null) return null;
        Pet pet = new Pet();
        pet.setId(petId);
        return pet;

    }

    default Veterinarian mapVaterinarianIdToVaterinarian(Long veterinarianId){
        if(veterinarianId == null) return null;
        Veterinarian vet = new Veterinarian();
        vet.setId(veterinarianId);
        return vet;

    }
}
