package com.leserviteurs.sn.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leserviteurs.sn.bibliotheque.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}