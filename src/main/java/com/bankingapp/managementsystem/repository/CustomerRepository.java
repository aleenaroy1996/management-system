package com.bankingapp.managementsystem.repository;

import com.bankingapp.managementsystem.model.Customer;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//public interface CustomerRepository extends JpaRepository<Customer, Integer> {
@Repository
public interface CustomerRepository extends Neo4jRepository<Customer, Long> {

    Optional<Customer> findByUserName(String userName);

    @Query(value = "MATCH (a:Customer),(b:Loan) \n" +
            "WHERE a.userName = $username AND ID(b) = $loanId \n" +
            "CREATE (a)-[r:APPLIED]->(b)")
    @Transactional
    void createAppliedRelationship(@Param("username") String username, @Param("loanId") Long loanId);
}
