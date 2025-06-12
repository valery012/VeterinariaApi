package com.ProyectoF.Veterinaria.persistence.repositorylmpl;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.domain.dto.PetDTO;
import com.ProyectoF.Veterinaria.domain.repository.AppointmentRepository;
import com.ProyectoF.Veterinaria.persistence.crud.AppointmentCrud;
import com.ProyectoF.Veterinaria.persistence.entity.Appointment;
import com.ProyectoF.Veterinaria.persistence.entity.Pet;
import com.ProyectoF.Veterinaria.persistence.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class AppointmentRepositorylmpl implements AppointmentRepository {

    @Autowired
    private AppointmentCrud appointmentCrud;

    @Autowired
    private AppointmentMapper appointmentMapper;


    @Override
    public Iterable<AppointmentDTO> findAll() {
        return StreamSupport.stream(appointmentCrud.findAll().spliterator(), false)
                .map(appointmentMapper::toDto)
                .toList();
    }

    @Override
    public Optional<AppointmentDTO> findById(Long id) {
        return appointmentCrud.findById(id)
                .map(appointmentMapper::toDto);
    }

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentMapper.toEntity(appointmentDTO);
        Appointment saveappointment  = appointmentCrud.save(appointment);
        return appointmentMapper.toDto(saveappointment);
    }

    @Override
    public void delete(Long id) {
        appointmentCrud.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return appointmentCrud.existsById(id);
    }

    @Override
    public long count() {
        return appointmentCrud.count();
    }

    @Override
    public Iterable<AppointmentDTO> findByPetId(Long id) {
        return StreamSupport.stream(appointmentCrud.findByPetId(id).spliterator(), false)
                .map(appointmentMapper::toDto)
                .toList();
    }
}
