package com.ProyectoF.Veterinaria.domain.repository;

import com.ProyectoF.Veterinaria.domain.dto.PetDTO;

import java.util.Optional;

public interface PetRepository {
    Iterable<PetDTO> findAll();

    Optional<PetDTO> findById(Long id);

    PetDTO save(PetDTO petDto);

    void delete(Long id);

    boolean existsById(Long id);

    long count();

    public Iterable<PetDTO> findByOwnerId(Long id);



}
