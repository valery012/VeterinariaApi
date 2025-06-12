package com.ProyectoF.Veterinaria.persistence.crud;

import com.ProyectoF.Veterinaria.persistence.entity.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetCrud extends CrudRepository<Pet, Long> {
    Iterable<Pet> findByOwnerId(Long ownerId);
}
