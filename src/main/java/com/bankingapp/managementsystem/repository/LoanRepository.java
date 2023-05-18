package com.bankingapp.managementsystem.repository;

import com.bankingapp.managementsystem.model.Loan;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends Neo4jRepository<Loan, Long> {

}
