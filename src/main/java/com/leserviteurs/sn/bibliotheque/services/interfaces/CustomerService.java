package com.leserviteurs.sn.bibliotheque.services.interfaces;

import java.util.List;
import com.leserviteurs.sn.bibliotheque.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> readAllCustomers();

    CustomerDTO findById(long id);

    CustomerDTO updateCustomer(long id, CustomerDTO customerDTO);

    void deleteById(long id);

    void deleteAllCustomers();
}