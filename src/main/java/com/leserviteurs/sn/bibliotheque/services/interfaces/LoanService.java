package com.leserviteurs.sn.bibliotheque.services.interfaces;

import java.util.List;
import com.leserviteurs.sn.bibliotheque.dto.LoanDTO;

public interface LoanService {
    LoanDTO createLoan(LoanDTO loanDTO);
    List<LoanDTO> readAllLoans();
    LoanDTO findById(long id);
    LoanDTO updateLoan(long id, LoanDTO loanDTO);
    void deleteById(long id);
    void deleteAllLoans();
}
