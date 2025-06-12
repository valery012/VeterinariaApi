package com.ProyectoF.Veterinaria.domain.service;

import com.ProyectoF.Veterinaria.domain.dto.PetDTO;
import com.ProyectoF.Veterinaria.domain.dto.ProductDTO;
import com.ProyectoF.Veterinaria.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<ProductDTO> findAll() {
        return productRepository.findAll();
    }


    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id);
    }


    public  ProductDTO save(ProductDTO productDto) {
        return productRepository.save(productDto);
    }

    public ProductDTO update(ProductDTO productDTO) {
        return productRepository.save(productDTO);
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }

    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }

    public long count() {
        return productRepository.count();
    }

}
