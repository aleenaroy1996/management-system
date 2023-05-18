package com.bankingapp.managementsystem.service;

import com.bankingapp.managementsystem.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CustomerService {
    public Boolean registerCustomer(Customer customer);

   public Boolean loginCustomer(String userName, String password);
    public ResponseEntity<Object> depositAmount(String userName, String accountType,Double amount);
    public ResponseEntity<Object> accountDetails(String userName);
}
