package com.ProyectoF.Veterinaria.domain.repository;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.domain.dto.VeterinarianDTO;
import com.ProyectoF.Veterinaria.persistence.entity.Veterinarian;

import java.util.Optional;

public interface VeterinarianRepository {

    Iterable<VeterinarianDTO> findAll();

    Optional<VeterinarianDTO> findById(Long id);

    VeterinarianDTO save(VeterinarianDTO veterinarianDTO);

    void delete(Long id);

    boolean existsById(Long id);

    long count();

    boolean ValidationUser(Long id , String password);
}
