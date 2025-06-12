package com.ProyectoF.Veterinaria.domain.repository;

import com.ProyectoF.Veterinaria.domain.dto.OwnerDTO;

import java.util.Optional;

public interface OwnerRepository {

    Iterable<OwnerDTO> findAll();

    Optional<OwnerDTO> findById(Long id);

    OwnerDTO save(OwnerDTO ownerDTO);

    void delete(Long id);

    boolean existsById(Long id);

    long count();
}
