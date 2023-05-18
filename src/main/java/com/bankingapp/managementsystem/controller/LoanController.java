package com.bankingapp.managementsystem.controller;

import com.bankingapp.managementsystem.model.Loan;
import com.bankingapp.managementsystem.service.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoanController {
    @Autowired
    private LoanServiceImpl loanService;
    @PostMapping("/apply")
    public ResponseEntity<Loan> applyLoan(@RequestBody Loan loan, @RequestParam String userName) {
        Loan savedLoan = loanService.applyLoan(loan,userName);
        return new ResponseEntity<>(savedLoan, HttpStatus.OK);
    }
}
