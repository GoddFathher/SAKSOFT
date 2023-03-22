package in.saksoft.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.saksoft.entity.Employees;
import in.saksoft.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employees>> getAllTheEmployess(){
	List<Employees> allEmployees = service.getAllEmployees();	
	return new ResponseEntity<List<Employees>>(allEmployees,HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Optional<Employees>> findSpecifiedEmployee(@PathVariable int id){
		Optional<Employees> emp = service.getEmployee(id);
		return new ResponseEntity<Optional<Employees>>(emp,HttpStatus.OK);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<String> upsert(@RequestBody Employees emp){
		String upsert = service.upsert(emp);
		return new ResponseEntity<String>(upsert,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteSpecifiedIdData(@PathVariable int id){
		String deleteEmployee = service.deleteEmployee(id);
		return new ResponseEntity<String>(deleteEmployee,HttpStatus.OK);
	}
	
}
