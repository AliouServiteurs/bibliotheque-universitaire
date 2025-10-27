package com.leserviteurs.sn.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leserviteurs.sn.bibliotheque.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
