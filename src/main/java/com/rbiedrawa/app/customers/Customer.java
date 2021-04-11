package com.rbiedrawa.app.customers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "customers")
@ToString
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	private final String name;
}
