package com.ProyectoF.Veterinaria.domain.service;

import com.ProyectoF.Veterinaria.domain.dto.PetDTO;
import com.ProyectoF.Veterinaria.domain.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Iterable<PetDTO> findAll() {
        return petRepository.findAll();
    }


    public Optional<PetDTO> findById(Long id) {
        return petRepository.findById(id);
    }


    public PetDTO save(PetDTO petDto) {
        return petRepository.save(petDto);
    }

    public PetDTO update(PetDTO petDTO) {
        return petRepository.save(petDTO);
    }

    public void delete(Long id) {
        petRepository.delete(id);
    }

    public boolean existsById(Long id) {
        return petRepository.existsById(id);
    }

    public long count() {
        return petRepository.count();
    }

    public Iterable<PetDTO> findByOwnerId(Long id){
        return petRepository.findByOwnerId(id);
    }


}
