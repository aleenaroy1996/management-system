package com.bankingapp.managementsystem.service;

import com.bankingapp.managementsystem.model.Customer;
import com.bankingapp.managementsystem.model.Loan;

public interface LoanService {
    public Loan applyLoan(Loan loan, String userName);
    public Loan getLoan(Long id);

}
