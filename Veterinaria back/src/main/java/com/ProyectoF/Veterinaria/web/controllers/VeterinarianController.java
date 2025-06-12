package com.ProyectoF.Veterinaria.web.controllers;

import com.ProyectoF.Veterinaria.domain.dto.VeterinarianDTO;
import com.ProyectoF.Veterinaria.domain.service.VeterinarianService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/veterinarians")
@CrossOrigin("*")
@Tag(name = "Veterinarians", description = "API para veterinaria")
public class VeterinarianController {
    private final VeterinarianService veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService) {
        this.veterinarianService = veterinarianService;
    }

    @Operation(summary = "Obtener todos los veterinarios")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/all") // esto para llamar los metodos
    public ResponseEntity<Iterable<VeterinarianDTO>> getAll() {
        return ResponseEntity.ok(veterinarianService.findAll());
    }


    @Operation(summary = "Obtener veterinarios por ID")
    @ApiResponse(responseCode = "200", description = "Veterinario encontrada")
    @ApiResponse(responseCode = "404", description = "Veterinario no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/{id}")
    public ResponseEntity<VeterinarianDTO> getById(@PathVariable Long id) {
        Optional<VeterinarianDTO> pet = veterinarianService.findById(id);
        return pet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Operation(summary = "Crear veterinario")
    @ApiResponse(responseCode = "201", description = "Veterinario creada")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @ApiResponse(responseCode = "405", description = "Link no valido o metodo no encontrado")
    @PostMapping("/save")
    public ResponseEntity<VeterinarianDTO> create(@Valid @RequestBody VeterinarianDTO veterinarianDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(veterinarianService.save(veterinarianDTO));
    }


    @Operation(summary = "Actualizar veterinario")
    @ApiResponse(responseCode = "200", description = "Veterinario actualizada")
    @ApiResponse(responseCode = "404", description = "Veterinario no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @PutMapping("/update/{id}")
    public ResponseEntity<VeterinarianDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody VeterinarianDTO veterinarianDTO) {

        if (!veterinarianService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        veterinarianDTO.setId(id);
        return ResponseEntity.ok(veterinarianService.update(veterinarianDTO));
    }


    @Operation(summary = "Eliminar propietario")
    @ApiResponse(responseCode = "204", description = "Propietario eliminado")
    @ApiResponse(responseCode = "404", description = "propietario no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!veterinarianService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        veterinarianService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Contar propietarios")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(veterinarianService.count());
    }

    @Operation(summary = "Validar usuario veterinario por ID y contraseña")
    @ApiResponse(responseCode = "200", description = "Validación completada")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateUser(@RequestParam Long id, @RequestParam String password) {
        boolean isValid = veterinarianService.ValidationUser(id, password);
        return ResponseEntity.ok(isValid);
    }
}
