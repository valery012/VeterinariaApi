package com.ProyectoF.Veterinaria.persistence.crud;

import com.ProyectoF.Veterinaria.persistence.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerCrud extends CrudRepository<Owner, Long> {
}
