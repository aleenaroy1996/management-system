package com.bankingapp.managementsystem.model;

import java.math.BigDecimal;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "loans")
@Node
public class Loan {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue
	private Long id;
	private String type;
	private Double amount;
	private String applyDate;
	private Double interestRate;
	private Integer duration;
	@Relationship(type = "APPLIED", direction = Relationship.Direction.INCOMING)
	private AppliedRelationship appliedRelationship;
}

