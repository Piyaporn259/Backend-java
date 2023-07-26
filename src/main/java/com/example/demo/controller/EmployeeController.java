package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.hibernate.metamodel.spi.EmbeddableRepresentationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;

	private List<Employee> data = new ArrayList<Employee>();
	
	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee body) 
	{
	   
			   return employeeRepository.save(body) ;
		   }
	
	@GetMapping("/employee/{employeeId}")
	public Optional<Employee>  getEmployeeDetai(@PathVariable Integer employeeId) {
	
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		
		return employee;
	}
	@PutMapping("/employee/{employeeId}")
	public Employee updateEmployee(@PathVariable Integer employeeId,@RequestBody Employee body){
		
			Optional<Employee> employeee = employeeRepository.findById(employeeId);
			
			if (employeee.isPresent()) {
				Employee employeeEdit = employeee.get();
				employeee.get().setFristName(body.getFristName());
				employeee.get().setLastName(body.getLastName());
				employeee.get().setSalary(body.getSalary());
				employeee.get().setEmployeeId(body.getEmployeeId());
				
				employeeRepository.save(employeee.get());
				return employeee.get();
				
			}else {
				return null;
				}
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable Integer employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isPresent()) {
			employeeRepository.delete(employee.get ());
			
			return "DELETE SUCSESS";
			
		}else {
			return "EMPLOYEE not found";
		}
		}
		
}
