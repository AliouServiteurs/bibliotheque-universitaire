package com.leserviteurs.sn.bibliotheque.mapper;

import org.mapstruct.Mapper;

import com.leserviteurs.sn.bibliotheque.dto.LoanDTO;
import com.leserviteurs.sn.bibliotheque.entity.Loan;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoanDTO toLoanDTO(Loan loan);

    Loan toLoan(LoanDTO loanDTO);
}
