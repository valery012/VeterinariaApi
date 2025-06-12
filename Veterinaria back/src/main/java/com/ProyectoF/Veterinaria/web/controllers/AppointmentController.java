package com.ProyectoF.Veterinaria.web.controllers;

import com.ProyectoF.Veterinaria.domain.dto.AppointmentDTO;
import com.ProyectoF.Veterinaria.domain.dto.PetDTO;
import com.ProyectoF.Veterinaria.domain.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*") // aqui
@Tag(name = "Appointments", description = "API para veterinaria")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Operation(summary = "Obtener todas las Citas")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/all")  // aquiii
    public ResponseEntity<Iterable<AppointmentDTO>> getAll() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @Operation(summary = "Obtener todas las Citas por mascota")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/by-petId")
    public ResponseEntity<Iterable<AppointmentDTO>> getAllByDate(Long id) {return  ResponseEntity.ok(appointmentService.findByPetId(id));}


    @Operation(summary = "Obtener citas por ID")
    @ApiResponse(responseCode = "200", description = "Cita encontrada")
    @ApiResponse(responseCode = "404", description = "Cita no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getById(@PathVariable Long id) {
        Optional<AppointmentDTO> pet = appointmentService.findById(id);return pet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Operation(summary = "Crear cita")
    @ApiResponse(responseCode = "201", description = "Cita creada")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @ApiResponse(responseCode = "405", description = "Link no valido o metodo no encontrado")
    @PostMapping("/save")
    public ResponseEntity<AppointmentDTO> create(@Valid @RequestBody AppointmentDTO appointmentDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appointmentService.save(appointmentDTO));
    }


    @Operation(summary = "Actualizar citas")
    @ApiResponse(responseCode = "200", description = "Cita actualizada")
    @ApiResponse(responseCode = "404", description = "Cita no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody AppointmentDTO appointmentDTO) {

        if (!appointmentService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        appointmentDTO.setId(id);
        return ResponseEntity.ok(appointmentService.update(appointmentDTO));
    }


    @Operation(summary = "Eliminar cita")
    @ApiResponse(responseCode = "204", description = "Cita eliminada")
    @ApiResponse(responseCode = "404", description = "Cita no encontrada")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!appointmentService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Contar mascotas")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Link no valido")
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(appointmentService.count());
    }



}
