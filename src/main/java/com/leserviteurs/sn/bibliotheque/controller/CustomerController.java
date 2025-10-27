package com.leserviteurs.sn.bibliotheque.controller;

import com.leserviteurs.sn.bibliotheque.dto.CustomerDTO;
import com.leserviteurs.sn.bibliotheque.services.interfaces.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Abonnés", description = "Endpoints pour gérer les abonnés (étudiants, professeurs, etc.)")
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Créer un abonné")
    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(dto));
    }

    @Operation(summary = "Lister tous les abonnés")
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        return ResponseEntity.ok(customerService.readAllCustomers());
    }

    @Operation(summary = "Trouver un abonné par ID")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @Operation(summary = "Mettre à jour un abonné")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        return ResponseEntity.ok(customerService.updateCustomer(id, dto));
    }

    @Operation(summary = "Supprimer un abonné")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Supprimer tous les abonné")
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        customerService.deleteAllCustomers();
        return ResponseEntity.noContent().build();
    }
}
