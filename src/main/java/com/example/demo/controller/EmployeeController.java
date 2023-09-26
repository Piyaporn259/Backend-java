package com.example.demo.controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RoleRepository;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
	

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	SkillRepository skillRepository;


	@GetMapping("/employee")
	public ResponseEntity<Object> getEmployee() {

		try {
			
			List<Employee> employees = employeeRepository.findAll();
			return new ResponseEntity<>(employees, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>("Integer server  error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/employee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee body) {
		try {
			Optional<Role> role = roleRepository.findById(4);
					
		    body.setRole(role.get());
    
			Employee employee = employeeRepository.save(body);
			
			for (Skill skill  : body.getSkills()) {
				skill.setEmployee(employee);
				skillRepository.save(skill);
				
			}
			
			return new ResponseEntity<>(employee, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Object> getEmployeeDetai(@PathVariable Integer employeeId) {

		try {
			Optional<Employee> employee = employeeRepository.findById(employeeId);
			if (employee.isPresent()) {
				return new ResponseEntity<>(employee, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Employee not found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/employee/{employeeId}")
	public ResponseEntity<Object> updatemployee(@PathVariable Integer employeeId, @RequestBody Employee body) {

		try {
			Optional<Employee> employeee = employeeRepository.findById(employeeId);

			if (employeee.isPresent()) {
				Employee employeeEdit = employeee.get();
				employeeEdit.setFristName(body.getFristName());			
				employeeEdit.setLastName(body.getLastName());
				employeeEdit.setSalary(body.getSalary());
				employeeEdit.setEmployeeId(body.getEmployeeId());

				employeeRepository.save(employeeEdit);
				return new ResponseEntity<>(employeee, HttpStatus.OK);

			} else {
				return new ResponseEntity<>("Employee not found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Integer server  error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<Object> deleteemployee(@PathVariable Integer employeeId) {
		try {
			Optional<Employee> employee = employeeRepository.findById(employeeId);
			if (employee.isPresent()) {
				employeeRepository.delete(employee.get());

				return new ResponseEntity<>("DELETE SUCSESS", HttpStatus.OK);

			} else {
				return new ResponseEntity<>("EMPLOYEE not found", HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>("Internal server error", HttpStatus.OK);
	}

}