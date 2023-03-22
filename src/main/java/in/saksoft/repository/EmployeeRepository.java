package in.saksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.saksoft.entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer>{

}
