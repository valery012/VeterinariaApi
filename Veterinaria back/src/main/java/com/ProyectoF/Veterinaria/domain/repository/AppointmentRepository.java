package com.ProyectoF.Veterinaria.domain.repository;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.domain.dto.PetDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public interface AppointmentRepository {

    Iterable<AppointmentDTO> findAll();

    Optional<AppointmentDTO> findById(Long id);

    AppointmentDTO save(AppointmentDTO appointmentDTO);

    void delete(Long id);

    boolean existsById(Long id);

    long count();

    public Iterable<AppointmentDTO> findByPetId(Long id);
}
