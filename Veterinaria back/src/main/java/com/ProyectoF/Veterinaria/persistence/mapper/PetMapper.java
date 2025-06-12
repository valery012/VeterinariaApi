package com.ProyectoF.Veterinaria.persistence.mapper;


import com.ProyectoF.Veterinaria.domain.dto.PetDTO;
import com.ProyectoF.Veterinaria.persistence.entity.Owner;
import com.ProyectoF.Veterinaria.persistence.entity.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface PetMapper {
    


    @Mapping(source = "owner.id", target = "ownerId")
    PetDTO toDto(Pet pet);

    @Mapping(target = "owner" , source = "ownerId")
    Pet toEntity(PetDTO petDTO);

    default Owner mapOwnerIdToOwner(Long ownerId){
        if(ownerId == null) return null;
        Owner owner = new Owner();
        owner.setId(ownerId);
        return owner;

    }


}
