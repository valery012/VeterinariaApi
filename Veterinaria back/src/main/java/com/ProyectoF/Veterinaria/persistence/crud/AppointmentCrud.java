package com.ProyectoF.Veterinaria.persistence.crud;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.persistence.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface AppointmentCrud extends CrudRepository<Appointment, Long> {
    Iterable<Appointment> findByPetId(Long petId);
}
