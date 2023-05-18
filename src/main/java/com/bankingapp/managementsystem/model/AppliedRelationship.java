package com.bankingapp.managementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type = "APPLIED")
public class AppliedRelationship {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Customer customer;
    @EndNode
    private Loan loan;

    private String userName;
    private Long loanId;

}
