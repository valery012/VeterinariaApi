package com.ProyectoF.Veterinaria.web.controllers;


import com.ProyectoF.Veterinaria.domain.dto.OwnerDTO;
import com.ProyectoF.Veterinaria.domain.service.OwnerService;
import com.ProyectoF.Veterinaria.persistence.entity.Owner;
import com.ProyectoF.Veterinaria.persistence.repositorylmpl.OwnerRepositorylmpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/owners")
@CrossOrigin(origins = "*")
@Tag(name = "Pets", description = "API para veterinaria")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Operation(summary = "Obtener todos los propietarios")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/all")
    public ResponseEntity<Iterable<OwnerDTO>> getAll() {
        return ResponseEntity.ok(ownerService.findAll());
    }


    @Operation(summary = "Obtener propietarios por ID")
    @ApiResponse(responseCode = "200", description = "Propietario encontrada")
    @ApiResponse(responseCode = "404", description = "Propietario no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> getById(@PathVariable Long id) {
        Optional<OwnerDTO> pet = ownerService.findById(id);
        return pet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Operation(summary = "Crear propietario")
    @ApiResponse(responseCode = "201", description = "Propietario creada")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @ApiResponse(responseCode = "405", description = "Link no valido o metodo no encontrado")
    @PostMapping("/save")
    public ResponseEntity<OwnerDTO> create(@Valid @RequestBody OwnerDTO ownerdto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ownerService.save(ownerdto));
    }


    @Operation(summary = "Actualizar propietario")
    @ApiResponse(responseCode = "200", description = "Propietario actualizada")
    @ApiResponse(responseCode = "404", description = "Propietario no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @PutMapping("/update/{id}")
    public ResponseEntity<OwnerDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody OwnerDTO ownerDTO) {

        if (!ownerService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        ownerDTO.setId(id);
        return ResponseEntity.ok(ownerService.update(ownerDTO));
    }


    @Operation(summary = "Eliminar propietario")
    @ApiResponse(responseCode = "204", description = "Propietario eliminado")
    @ApiResponse(responseCode = "404", description = "propietario no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!ownerService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        ownerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Contar propietarios")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(ownerService.count());
    }
}
