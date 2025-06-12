package com.ProyectoF.Veterinaria.persistence.repositorylmpl;

import com.ProyectoF.Veterinaria.domain.dto.PetDTO;
import com.ProyectoF.Veterinaria.domain.repository.PetRepository;
import com.ProyectoF.Veterinaria.persistence.crud.PetCrud;
import com.ProyectoF.Veterinaria.persistence.entity.Pet;
import com.ProyectoF.Veterinaria.persistence.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class PetRepositorylmpl implements PetRepository {

    @Autowired
    private PetCrud petCrud;
    @Autowired
    private PetMapper petMapper;

    @Override
    public Iterable<PetDTO> findAll() {
        return StreamSupport.stream(petCrud.findAll().spliterator(), false)
                .map(petMapper::toDto)
                .toList();
    }

    @Override
    public Optional<PetDTO> findById(Long id) {
        return petCrud.findById(id)
                .map(petMapper::toDto);
    }

    @Override
    public PetDTO save(PetDTO petDto) {
        Pet pet = petMapper.toEntity(petDto);
        Pet savedPet = petCrud.save(pet);
        return petMapper.toDto(savedPet);
    }

    @Override
    public void delete(Long id)  {
        petCrud.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return petCrud.existsById(id);
    }

    @Override
    public long count() {
        return petCrud.count();
    }

    @Override
    public Iterable<PetDTO> findByOwnerId(Long id){
        return StreamSupport.stream(petCrud.findByOwnerId(id).spliterator(), false)
                .map(petMapper::toDto)
                .toList();

    }
}
