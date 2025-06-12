package com.ProyectoF.Veterinaria.domain.service;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.domain.dto.OwnerDTO;
import com.ProyectoF.Veterinaria.domain.repository.OwnerRepository;
import com.ProyectoF.Veterinaria.persistence.crud.OwnerCrud;
import com.ProyectoF.Veterinaria.persistence.repositorylmpl.OwnerRepositorylmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Iterable<OwnerDTO> findAll() {
        return ownerRepository.findAll();
    }


    public Optional<OwnerDTO> findById(Long id) {
        return ownerRepository.findById(id);
    }


    public OwnerDTO save(OwnerDTO ownerDTO) {
        return ownerRepository.save(ownerDTO);
    }

    public OwnerDTO update(OwnerDTO ownerDTO) {
        return ownerRepository.save(ownerDTO);
    }

    public void delete(Long id) {
        ownerRepository.delete(id);
    }

    public boolean existsById(Long id) {
        return ownerRepository.existsById(id);
    }

    public long count() {
        return ownerRepository.count();
    }
}
