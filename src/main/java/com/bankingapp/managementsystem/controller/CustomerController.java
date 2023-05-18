package com.bankingapp.managementsystem.controller;

import com.bankingapp.managementsystem.model.Customer;
import com.bankingapp.managementsystem.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        log.info("Registration started!");
        Boolean result = customerService.registerCustomer(customer);
        if(result==true){
            log.info("User Registered Successfully!!!");
            return new ResponseEntity<String>("User registered successfully",HttpStatus.CREATED);
        }
        log.info("User already exists");
        return new ResponseEntity<String>("User already exists",HttpStatus.OK);
    }
    @GetMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestParam String userName, @RequestParam String password) {
        Boolean result = customerService.loginCustomer(userName,password);
        if(result==true){
            log.info("Logged in successfully!!!");
            return new ResponseEntity<String>("Logged in successfully!!!",HttpStatus.OK);
        }
        log.info("Invalid Credentials!!!");
        return new ResponseEntity<String>("Invalid Credentials!!!",HttpStatus.OK);
    }

    @PutMapping("/deposit")
    public ResponseEntity<Object> depositAmount(@RequestParam String userName, @RequestParam String accountType, @RequestParam Double amount) {
        return customerService.depositAmount(userName,accountType,amount);
    }

    @GetMapping("/details")
    public ResponseEntity<Object> accountDetails(@RequestParam String userName) {
        return customerService.accountDetails(userName);
    }
}
