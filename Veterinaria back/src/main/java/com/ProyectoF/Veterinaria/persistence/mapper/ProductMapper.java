package com.ProyectoF.Veterinaria.persistence.mapper;

import com.ProyectoF.Veterinaria.domain.dto.OwnerDTO;
import com.ProyectoF.Veterinaria.domain.dto.ProductDTO;
import com.ProyectoF.Veterinaria.persistence.entity.Owner;
import com.ProyectoF.Veterinaria.persistence.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    Product toEntity(ProductDTO productDTO);
}
