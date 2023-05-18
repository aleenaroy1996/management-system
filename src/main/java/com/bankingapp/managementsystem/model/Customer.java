package com.bankingapp.managementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Node
//@Table(name="customer")
public class Customer {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String address;
    private String country;
    private String state;
    private String email;
    private Long contactNo;
    private String birthDate;
    private String accountType;
    private String branchName;
    private Double initialDeposit;
    private String proofType;
    private String documentNo;

    @Relationship(type = "APPLIED")
    private Loan loan;
}
