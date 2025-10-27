package com.leserviteurs.sn.bibliotheque.mapper;

import org.mapstruct.Mapper;

import com.leserviteurs.sn.bibliotheque.dto.CustomerDTO;
import com.leserviteurs.sn.bibliotheque.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  CustomerDTO toCustomerDTO(Customer customer);

  Customer toCustomer(CustomerDTO customerDTO);
}
