package com.leserviteurs.sn.bibliotheque.services.interfaces;

import java.util.List;
import com.leserviteurs.sn.bibliotheque.dto.BookDTO;

public interface BookService {
    BookDTO createBook(BookDTO bookDTO);

    List<BookDTO> readAllBooks();

    BookDTO findById(long id);

    BookDTO updateBook(long id, BookDTO bookDTO);

    void deleteById(long id);

    void deleteAllBooks();
}
