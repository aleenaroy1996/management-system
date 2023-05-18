package com.bankingapp.managementsystem.service;


import com.bankingapp.managementsystem.model.AppliedRelationship;
import com.bankingapp.managementsystem.model.Loan;
import com.bankingapp.managementsystem.repository.CustomerRepository;
import com.bankingapp.managementsystem.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
    private LoanRepository loanRepository;
    @Autowired
    private CustomerRepository customerRepository;
    
    public Loan applyLoan(Loan loan, String userName) {
        Loan savedLoan = loanRepository.save(loan);
        customerRepository.createAppliedRelationship(userName, savedLoan.getId());
        AppliedRelationship rel = new AppliedRelationship();
        rel.setUserName(userName);
        rel.setLoanId(savedLoan.getId());
        savedLoan.setAppliedRelationship(rel);
        return savedLoan;
    }
    
    public Loan getLoan(Long id) {
        return loanRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan not found with id " + id));
    }
}
