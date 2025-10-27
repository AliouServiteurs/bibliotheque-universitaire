package com.leserviteurs.sn.bibliotheque.mapper;

import org.mapstruct.Mapper;

import com.leserviteurs.sn.bibliotheque.dto.BookDTO;
import com.leserviteurs.sn.bibliotheque.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toBookDTO(Book book);

    Book toBook(BookDTO bookDTO);
}
