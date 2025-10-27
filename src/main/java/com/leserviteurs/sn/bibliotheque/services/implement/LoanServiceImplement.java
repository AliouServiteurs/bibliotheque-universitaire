package com.leserviteurs.sn.bibliotheque.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.leserviteurs.sn.bibliotheque.dto.LoanDTO;
import com.leserviteurs.sn.bibliotheque.entity.Loan;
import com.leserviteurs.sn.bibliotheque.exception.ResourceNotFoundException;
import com.leserviteurs.sn.bibliotheque.mapper.LoanMapper;
import com.leserviteurs.sn.bibliotheque.repository.LoanRepository;
import com.leserviteurs.sn.bibliotheque.services.interfaces.LoanService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanServiceImplement implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Override
    public LoanDTO createLoan(LoanDTO loanDTO) {
        Loan loan = loanMapper.toLoan(loanDTO);
        return loanMapper.toLoanDTO(loanRepository.save(loan));
    }

    @Override
    public List<LoanDTO> readAllLoans() {
        return loanRepository.findAll().stream()
                             .map(loanMapper::toLoanDTO)
                             .collect(Collectors.toList());
    }

    @Override
    public LoanDTO findById(long id) {
        Loan loan = loanRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id " + id));
        return loanMapper.toLoanDTO(loan);
    }

    @Override
    public LoanDTO updateLoan(long id, LoanDTO loanDTO) {
        Loan loan = loanRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id " + id));

        if (loanDTO.getBook() != null) loan.setBook(loanDTO.getBook());
        if (loanDTO.getCustomer() != null) loan.setCustomer(loanDTO.getCustomer());
        if (loanDTO.getDateEmprunt() != null) loan.setDateEmprunt(loanDTO.getDateEmprunt());
        if (loanDTO.getDateRetourPrevue() != null) loan.setDateRetourPrevue(loanDTO.getDateRetourPrevue());
        if (loanDTO.getDateRetourReelle() != null) loan.setDateRetourReelle(loanDTO.getDateRetourReelle());

        return loanMapper.toLoanDTO(loanRepository.save(loan));
    }

    @Override
    public void deleteById(long id) {
        if (!loanRepository.existsById(id))
            throw new ResourceNotFoundException("Loan not found with id " + id);
        loanRepository.deleteById(id);
    }

    @Override
    public void deleteAllLoans() {
        loanRepository.deleteAll();
    }
}