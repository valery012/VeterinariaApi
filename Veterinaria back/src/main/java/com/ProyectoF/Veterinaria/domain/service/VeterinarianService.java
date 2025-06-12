package com.ProyectoF.Veterinaria.domain.service;

import com.ProyectoF.Veterinaria.domain.dto.PetDTO;
import com.ProyectoF.Veterinaria.domain.dto.VeterinarianDTO;
import com.ProyectoF.Veterinaria.domain.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeterinarianService {

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    public Iterable<VeterinarianDTO> findAll() {
        return veterinarianRepository.findAll();
    }


    public Optional<VeterinarianDTO> findById(Long id) {
        return veterinarianRepository.findById(id);
    }


    public VeterinarianDTO save(VeterinarianDTO veterinarianDto) {
        return veterinarianRepository.save(veterinarianDto);
    }

    public VeterinarianDTO update(VeterinarianDTO veterinarianDTO) {
        return veterinarianRepository.save(veterinarianDTO);
    }

    public void delete(Long id) {
        veterinarianRepository.delete(id);
    }

    public boolean existsById(Long id) {
        return veterinarianRepository.existsById(id);
    }

    public long count() {
        return veterinarianRepository.count();
    }

    public boolean ValidationUser(Long id, String password) {
        return veterinarianRepository.ValidationUser(id, password);
    }
}
