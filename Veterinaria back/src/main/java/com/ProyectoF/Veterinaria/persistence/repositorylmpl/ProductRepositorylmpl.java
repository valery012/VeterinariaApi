package com.ProyectoF.Veterinaria.persistence.repositorylmpl;


import com.ProyectoF.Veterinaria.domain.dto.ProductDTO;
import com.ProyectoF.Veterinaria.domain.repository.ProductRepository;
import com.ProyectoF.Veterinaria.persistence.crud.ProductCrud;
import com.ProyectoF.Veterinaria.persistence.entity.Product;
import com.ProyectoF.Veterinaria.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class ProductRepositorylmpl implements ProductRepository {

    @Autowired
    private ProductCrud productCrud;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Iterable<ProductDTO> findAll() {
        return StreamSupport.stream(productCrud.findAll().spliterator(), false)
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return productCrud.findById(id)
                .map(productMapper::toDto);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedproduct = productCrud.save(product);
        return productMapper.toDto(savedproduct);
    }

    @Override
    public void delete(Long id) {
        productCrud.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return productCrud.existsById(id);
    }

    @Override
    public long count() {
        return productCrud.count();
    }
}
