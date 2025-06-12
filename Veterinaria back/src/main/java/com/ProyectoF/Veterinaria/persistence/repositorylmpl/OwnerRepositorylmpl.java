package com.ProyectoF.Veterinaria.persistence.repositorylmpl;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.domain.dto.OwnerDTO;
import com.ProyectoF.Veterinaria.domain.repository.OwnerRepository;
import com.ProyectoF.Veterinaria.persistence.crud.OwnerCrud;
import com.ProyectoF.Veterinaria.persistence.entity.Appointment;
import com.ProyectoF.Veterinaria.persistence.entity.Owner;
import com.ProyectoF.Veterinaria.persistence.mapper.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class OwnerRepositorylmpl implements OwnerRepository {

    @Autowired
    private OwnerCrud ownerCrud;

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public Iterable<OwnerDTO> findAll() {
        return StreamSupport.stream(ownerCrud.findAll().spliterator(), false)
                .map(ownerMapper::toDto)
                .toList();
    }

    @Override
    public Optional<OwnerDTO> findById(Long id) {
        return ownerCrud.findById(id)
                .map(ownerMapper::toDto);
    }

    @Override
    public OwnerDTO save(OwnerDTO ownerDTO) {
        Owner owner = ownerMapper.toEntity(ownerDTO);
        Owner saveOwner  = ownerCrud.save(owner);
        return ownerMapper.toDto(saveOwner);
    }

    @Override
    public void delete(Long id) {
        ownerCrud.deleteById(id);

    }

    @Override
    public boolean existsById(Long id) {
        return ownerCrud.existsById(id);
    }

    @Override
    public long count() {
        return ownerCrud.count();
    }
}
