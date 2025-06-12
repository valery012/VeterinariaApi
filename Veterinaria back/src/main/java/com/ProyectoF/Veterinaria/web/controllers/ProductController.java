package com.ProyectoF.Veterinaria.web.controllers;

import com.ProyectoF.Veterinaria.domain.dto.ProductDTO;
import com.ProyectoF.Veterinaria.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
@Tag(name = "Product", description = "API para veterinaria")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Obtener todos los productos")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/all")
    public ResponseEntity<Iterable<ProductDTO>> getAll() {
        return ResponseEntity.ok(productService.findAll());
    }


    @Operation(summary = "Obtener productos por ID")
    @ApiResponse(responseCode = "200", description = "Producto encontrada")
    @ApiResponse(responseCode = "404", description = "Producto no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        Optional<ProductDTO> pet = productService.findById(id);
        return pet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Operation(summary = "Crear producto")
    @ApiResponse(responseCode = "201", description = "Producto creada")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @ApiResponse(responseCode = "405", description = "Link no valido o metodo no encontrado")
    @PostMapping("/save")
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.save(productDTO));
    }


    @Operation(summary = "Actualizar producto")
    @ApiResponse(responseCode = "200", description = "Producto actualizada")
    @ApiResponse(responseCode = "404", description = "Producto no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductDTO productDTO) {

        if (!productService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        productDTO.setId(id);
        return ResponseEntity.ok(productService.update(productDTO));
    }


    @Operation(summary = "Eliminar producto")
    @ApiResponse(responseCode = "204", description = "Producto eliminado")
    @ApiResponse(responseCode = "404", description = "producto no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!productService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Contar productos")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(productService.count());
    }

}
