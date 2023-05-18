package com.bankingapp.managementsystem.service;

import com.bankingapp.managementsystem.model.Customer;
import com.bankingapp.managementsystem.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    public Boolean registerCustomer(Customer customer) {

        Optional<Customer> optionalCustomer = customerRepository.findByUserName(customer.getUserName());
        if(optionalCustomer.isPresent()){
            return Boolean.FALSE;
        }
        customerRepository.save(customer);

        return Boolean.TRUE;
    }

    @Override
    public Boolean loginCustomer(String userName, String password) {
        Optional<Customer> optionalCustomer = customerRepository.findByUserName(userName);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            return (userName.equals(customer.getUserName())&&password.equals(customer.getPassword()));
        }else {
            return Boolean.FALSE;
        }

    }

    @Override
    public ResponseEntity<Object> depositAmount(String userName,String accountType, Double amount) {
        Optional<Customer> optionalCustomer = customerRepository.findByUserName(userName);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            if(!accountType.equals(customer.getAccountType())){
                log.info("Invalid Account Type");
                return new ResponseEntity<Object>("Invalid Account Type", HttpStatus.OK);
            }
            customer.setInitialDeposit(customer.getInitialDeposit()+amount);
            customerRepository.save(customer);
            log.info("Amount deposited successfully!!");
            return new ResponseEntity<Object>(customer.getInitialDeposit(), HttpStatus.OK);
        }
            return new ResponseEntity<Object>("Invalid User", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> accountDetails(String userName) {
        Optional<Customer> optionalCustomer = customerRepository.findByUserName(userName);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            log.info("Details fetched successfully");
            return new ResponseEntity<Object>(customer, HttpStatus.OK);
        }else {
            log.info("User does not exist!!!");
            return new ResponseEntity<Object>("User does not exist!!!", HttpStatus.OK);
        }
    }

}
