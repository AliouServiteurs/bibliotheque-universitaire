package com.leserviteurs.sn.bibliotheque.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.leserviteurs.sn.bibliotheque.dto.BookDTO;
import com.leserviteurs.sn.bibliotheque.entity.Book;
import com.leserviteurs.sn.bibliotheque.exception.ResourceNotFoundException;
import com.leserviteurs.sn.bibliotheque.mapper.BookMapper;
import com.leserviteurs.sn.bibliotheque.repository.BookRepository;
import com.leserviteurs.sn.bibliotheque.services.interfaces.BookService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImplement implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        return bookMapper.toBookDTO(bookRepository.save(book));
    }

    @Override
    public List<BookDTO> readAllBooks() {
        return bookRepository.findAll().stream()
                             .map(bookMapper::toBookDTO)
                             .collect(Collectors.toList());
    }

    @Override
    public BookDTO findById(long id) {
        Book book = bookRepository.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        return bookMapper.toBookDTO(book);
    }

    @Override
    public BookDTO updateBook(long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

        if (bookDTO.getTitre() != null) book.setTitre(bookDTO.getTitre());
        if (bookDTO.getNombreExemplaireDisponible() != null)
            book.setNombreExemplaireDisponible(bookDTO.getNombreExemplaireDisponible());
        if (bookDTO.getNombreTotalExemplaire() != null)
            book.setNombreTotalExemplaire(bookDTO.getNombreTotalExemplaire());

        return bookMapper.toBookDTO(bookRepository.save(book));
    }

    @Override
    public void deleteById(long id) {
        if (!bookRepository.existsById(id))
            throw new ResourceNotFoundException("Book not found with id " + id);
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }
}