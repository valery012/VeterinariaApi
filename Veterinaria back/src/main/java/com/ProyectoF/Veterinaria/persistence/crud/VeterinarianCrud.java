package com.ProyectoF.Veterinaria.persistence.crud;

import com.ProyectoF.Veterinaria.persistence.entity.Veterinarian;
import org.springframework.data.repository.CrudRepository;

public interface VeterinarianCrud extends CrudRepository<Veterinarian, Long> {
}
