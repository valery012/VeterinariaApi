package com.ProyectoF.Veterinaria.web.controllers;

import com.ProyectoF.Veterinaria.domain.dto.PetDTO;
import com.ProyectoF.Veterinaria.domain.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "*")
@Tag(name = "Pets", description = "API para veterinaria")
public class PetController {

    private final PetService petService;


    @Autowired

    public PetController(PetService petService, HandlerMapping resourceHandlerMapping) {
        this.petService = petService;

    }

    @Operation(summary = "Obtener todas las mascotas")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/all")
    public ResponseEntity<Iterable<PetDTO>> getAll() {
        return ResponseEntity.ok(petService.findAll());
    }


    @Operation(summary = "Obtener las mascotas de un dueño")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/by-ownerId")
    public ResponseEntity<Iterable<PetDTO>> getAllByOwnerId(Long id){
        return ResponseEntity.ok(petService.findByOwnerId(id));
    }

    @Operation(summary = "Obtener mascota por ID")
    @ApiResponse(responseCode = "200", description = "Mascota encontrada")
    @ApiResponse(responseCode = "404", description = "Mascota no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getById(@PathVariable Long id) {
        Optional<PetDTO> pet = petService.findById(id);
        return pet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Operation(summary = "Crear mascota")
    @ApiResponse(responseCode = "201", description = "Mascota creada")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @ApiResponse(responseCode = "405", description = "Link no valido o metodo no encontrado")
    @PostMapping("/save")
    public ResponseEntity<PetDTO> create(@Valid @RequestBody PetDTO petDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(petService.save(petDTO));
    }


    @Operation(summary = "Actualizar mascota")
    @ApiResponse(responseCode = "200", description = "Mascota actualizada")
    @ApiResponse(responseCode = "404", description = "Mascota no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @PutMapping("/update/{id}")
    public ResponseEntity<PetDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody PetDTO petDTO) {

        if (!petService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        petDTO.setId(id);
        return ResponseEntity.ok(petService.update(petDTO));
    }


    @Operation(summary = "Eliminar mascota")
    @ApiResponse(responseCode = "204", description = "Mascota eliminada")
    @ApiResponse(responseCode = "404", description = "Mascota no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!petService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        petService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Contar mascotas")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(petService.count());
    }

}
