package com.ProyectoF.Veterinaria.domain.service;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.domain.dto.PetDTO;
import com.ProyectoF.Veterinaria.persistence.repositorylmpl.AppointmentRepositorylmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepositorylmpl appointmentRepositorylmpl;

    public Iterable<AppointmentDTO> findAll() {
        return appointmentRepositorylmpl.findAll();
    }


    public Optional<AppointmentDTO> findById(Long id) {
        return appointmentRepositorylmpl.findById(id);
    }


    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        return appointmentRepositorylmpl.save(appointmentDTO);
    }

    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        return appointmentRepositorylmpl.save(appointmentDTO);
    }

    public void delete(Long id) {
        appointmentRepositorylmpl.delete(id);
    }

    public boolean existsById(Long id) {
        return appointmentRepositorylmpl.existsById(id);
    }

    public long count() {
        return appointmentRepositorylmpl.count();
    }

    public Iterable<AppointmentDTO> findByPetId(Long id) {
        return appointmentRepositorylmpl.findByPetId(id);
    }
}
