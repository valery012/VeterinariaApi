package com.ProyectoF.Veterinaria.persistence.crud;

import com.ProyectoF.Veterinaria.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrud extends CrudRepository<Product, Long> {
}
