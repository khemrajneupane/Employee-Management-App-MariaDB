package fi.employee.employeerecord.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository <Employee, Long>{
	List<Employee> findByFname(String fname);
	List<Employee> findByFnameIgnoreCaseContaining(String fname);
	
}
