package com.example.demo.model;

import java.security.PrivateKey;
import java.util.List;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer employeeId;
	private String fristName;
	private String lastName;
	private Integer salary;
	
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String fristName, String lastName, Integer salary) {
		super();
		this.employeeId = employeeId;
		this.fristName = fristName;
		this.lastName = lastName;
		this.salary = salary;

	}
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	@ManyToOne
	@JoinColumn(name = "role_id")
		private Role role;
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	@OneToMany
	@JoinColumn(name = "employee_id")
	private List<Skill> skills;




	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}


	
}
