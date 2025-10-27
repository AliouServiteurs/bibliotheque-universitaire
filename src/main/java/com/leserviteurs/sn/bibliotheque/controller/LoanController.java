package com.leserviteurs.sn.bibliotheque.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.leserviteurs.sn.bibliotheque.dto.LoanDTO;
import com.leserviteurs.sn.bibliotheque.services.interfaces.LoanService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
@Validated
public class LoanController {

    private final LoanService loanService;

    @Operation(summary = "Créer un emprunt")
    @PostMapping
    public ResponseEntity<LoanDTO> create(@RequestBody LoanDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(dto));
    }

    @Operation(summary = "Lister tous les emprunts")
    @GetMapping
    public ResponseEntity<List<LoanDTO>> findAll() {
        return ResponseEntity.ok(loanService.readAllLoans());
    }

    @Operation(summary = "Trouver un emprunt par ID")
    @GetMapping("/{id}")
    public ResponseEntity<LoanDTO> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.findById(id));
    }

    @Operation(summary = "Mettre à jour un emprunt existant")
    @PutMapping("/{id}")
    public ResponseEntity<LoanDTO> update(@PathVariable long id, @Valid @RequestBody LoanDTO loanDTO) {
        LoanDTO updated = loanService.updateLoan(id, loanDTO);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Supprimé un emprunt")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        loanService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Supprim tous les emprunts")
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        loanService.deleteAllLoans();
        return ResponseEntity.noContent().build();
    }
}
