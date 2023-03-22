package in.saksoft.service;

import java.util.List;
import java.util.Optional;

import in.saksoft.entity.Employees;

public interface EmployeeService {

	public List<Employees> getAllEmployees();
	
	public Optional<Employees> getEmployee(int eId);
	
	public String upsert(Employees emp);
	
	public String deleteEmployee(int eId);
	
}
