package com.ProyectoF.Veterinaria.domain.repository;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.domain.dto.OwnerDTO;
import com.ProyectoF.Veterinaria.domain.dto.ProductDTO;

import java.util.Optional;

public interface ProductRepository {

    Iterable<ProductDTO> findAll();

    Optional<ProductDTO> findById(Long id);

    ProductDTO save(ProductDTO productDTO);

    void delete(Long id);

    boolean existsById(Long id);

    long count();
}
