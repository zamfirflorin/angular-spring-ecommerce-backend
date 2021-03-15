package com.rawdebun.ecommerce.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EMPLOYEES")
@Getter
@Setter
public class Employee {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
	private Long id; 
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "hire_date")
	private Date hireDate; 
	
	@Column(name = "job_id")
	private String jobId;
	
	@Column(name = "salary")
	private Long salary;
	
	@Column(name = "commission_pct", nullable = false)
	private Integer commissionPoint;
	
	@Column(name = "manager_id")
	private Long managerId;
	
	@Column(name = "department_id")
	private Long departmentId;
	
	
	
	
}
