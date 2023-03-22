package in.saksoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.saksoft.entity.Employees;
import in.saksoft.repository.EmployeeRepository;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employees> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Optional<Employees> getEmployee(int eId) {
		Optional<Employees> findById = repo.findById(eId);
		return findById;
	}

	@Override
	public String upsert(Employees emp) {
		repo.save(emp);
		return "Operation successful ...";
	}

	@Override
	public String deleteEmployee(int eId) {
		repo.deleteById(eId);
		return "Operation successful ...";
	}

}
