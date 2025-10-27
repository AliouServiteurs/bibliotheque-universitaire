package com.leserviteurs.sn.bibliotheque.dto;

import java.util.Date;

import com.leserviteurs.sn.bibliotheque.entity.Book;
import com.leserviteurs.sn.bibliotheque.entity.Customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanDTO {
    private long id;
    private Date dateEmprunt;
    private Date dateRetourPrevue;
    private Date dateRetourReelle;
    private Customer customer;
    private Book book;
}
