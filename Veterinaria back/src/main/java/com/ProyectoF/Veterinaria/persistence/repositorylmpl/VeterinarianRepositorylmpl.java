package com.ProyectoF.Veterinaria.persistence.repositorylmpl;

import com.ProyectoF.Veterinaria.domain.dto.VeterinarianDTO;
import com.ProyectoF.Veterinaria.domain.repository.VeterinarianRepository;
import com.ProyectoF.Veterinaria.persistence.crud.VeterinarianCrud;
import com.ProyectoF.Veterinaria.persistence.entity.Veterinarian;
import com.ProyectoF.Veterinaria.persistence.mapper.VeterinarianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class VeterinarianRepositorylmpl implements VeterinarianRepository {

    @Autowired
    private VeterinarianCrud veterinarianCrud;
    @Autowired
    private VeterinarianMapper veterinarianMapper;

    @Override
    public Iterable<VeterinarianDTO> findAll() {
        return StreamSupport.stream(veterinarianCrud.findAll().spliterator(), false)
                .map(veterinarianMapper::toDto)
                .toList();
    }

    @Override
    public Optional<VeterinarianDTO> findById(Long id) {
        return veterinarianCrud.findById(id)
                .map(veterinarianMapper::toDto);
    }

    @Override
    public VeterinarianDTO save(VeterinarianDTO veterinarianDTO) {
        Veterinarian veterinarian = veterinarianMapper.toEntity(veterinarianDTO);
        Veterinarian savedveterinarian = veterinarianCrud.save(veterinarian);
        return veterinarianMapper.toDto(savedveterinarian);
    }

    @Override
    public void delete(Long id) {
        veterinarianCrud.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return veterinarianCrud.existsById(id);
    }

    @Override
    public long count() {
        return veterinarianCrud.count();
    }

    @Override
    public boolean ValidationUser(Long id, String password) {
        Optional<Veterinarian> optionalVeterinarian = veterinarianCrud.findById(id);

        return optionalVeterinarian
                .map(vet -> vet.getPassword().equals(password))
                .orElse(false);

    }
}
