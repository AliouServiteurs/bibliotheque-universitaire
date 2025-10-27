package com.leserviteurs.sn.bibliotheque.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.leserviteurs.sn.bibliotheque.dto.CustomerDTO;
import com.leserviteurs.sn.bibliotheque.entity.Customer;
import com.leserviteurs.sn.bibliotheque.exception.ResourceNotFoundException;
import com.leserviteurs.sn.bibliotheque.mapper.CustomerMapper;
import com.leserviteurs.sn.bibliotheque.repository.CustomerRepository;
import com.leserviteurs.sn.bibliotheque.services.interfaces.CustomerService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImplement implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toCustomer(customerDTO);
        return customerMapper.toCustomerDTO(customerRepository.save(customer));
    }

    @Override
    public List<CustomerDTO> readAllCustomers() {
        return customerRepository.findAll().stream()
                                 .map(customerMapper::toCustomerDTO)
                                 .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(long id) {
        Customer customer = customerRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
        return customerMapper.toCustomerDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));

        if (customerDTO.getNomUtiliseur() != null) customer.setNomUtiliseur(customerDTO.getNomUtiliseur());
        if (customerDTO.getEmail() != null) customer.setEmail(customerDTO.getEmail());
        if (customerDTO.getNumeroTelephone() != null) customer.setNumeroTelephone(customerDTO.getNumeroTelephone());

        return customerMapper.toCustomerDTO(customerRepository.save(customer));
    }

    @Override
    public void deleteById(long id) {
        if (!customerRepository.existsById(id))
            throw new ResourceNotFoundException("Customer not found with id " + id);
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }
}
