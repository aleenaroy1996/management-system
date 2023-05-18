package com.bankingapp.managementsystem.graphqlcontroller;

import com.bankingapp.managementsystem.model.Customer;
import com.bankingapp.managementsystem.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GraphqlController {
    @Autowired
    private CustomerServiceImpl customerService;

    @QueryMapping
    public String login(@Argument String nameInput, @Argument String passwordInput) {
        Boolean result = customerService.loginCustomer(nameInput,passwordInput);
        if(result==true){
            return "Logged in successfully!!!";
        }
        return "Invalid Credentials!!!";
    }

    @MutationMapping
    public String register(@Argument Customer customer) {
        Boolean result = customerService.registerCustomer(customer);
        if(result==true){
            return "User registered successfully";
        }
        return "User already exists";
    }
}
