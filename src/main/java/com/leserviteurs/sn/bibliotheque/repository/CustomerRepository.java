package com.leserviteurs.sn.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leserviteurs.sn.bibliotheque.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
