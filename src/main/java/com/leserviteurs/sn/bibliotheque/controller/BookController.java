package com.leserviteurs.sn.bibliotheque.controller;

import com.leserviteurs.sn.bibliotheque.dto.BookDTO;
import com.leserviteurs.sn.bibliotheque.services.interfaces.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Livres", description = "Endpoints pour gérer les livres disponibles dans la bibliothèque")
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Validated
public class BookController {

    private final BookService bookService;

    @Operation(summary = "Créer un nouveau livre")
    @PostMapping
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookDTO));
    }

    @Operation(summary = "Lister tous les livres")
    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        return ResponseEntity.ok(bookService.readAllBooks());
    }

    @Operation(summary = "Trouver un livre par ID")
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @Operation(summary = "Mettre à jour un livre existant")
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.updateBook(id, bookDTO));
    }

    @Operation(summary = "Supprimer un livre")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Supprim tous les livres")
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        bookService.deleteAllBooks();
        return ResponseEntity.noContent().build();
    }
}
