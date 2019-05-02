package fi.employee.employeerecord;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.employee.employeerecord.domain.Department;
import fi.employee.employeerecord.domain.DepartmentRepository;
import fi.employee.employeerecord.domain.Employee;
import fi.employee.employeerecord.domain.EmployeeRepository;
import fi.employee.employeerecord.domain.Task;
import fi.employee.employeerecord.domain.TaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestForRepository {
	@Autowired
	DepartmentRepository drepo;
	@Autowired
	EmployeeRepository empr;
	@Autowired
	TaskRepository tsr;
	@Test
	public void createDepartment() {
		Department dpt = new Department("IT");
		drepo.save(dpt);
		assertThat(dpt.getName()).isEqualTo("IT");
	}
	@Test
	public void createTask() {
		Task tsk = new Task("Swimming","2019","Swimming program",400,"Yes");
		tsr.save(tsk);
		assertThat(tsk.getIsActive()).isEqualTo("Yes");
	}	
	@Test
	public void createEmployee() {
		Department dpt = new Department("IT");
		drepo.save(dpt);
		Task tsk = new Task("Swimming","2019","Swimming program",400,"Yes");
		tsr.save(tsk);
		empr.save(new Employee("Muna","Ghimire","muna@tuna.com","43261408","Chandragadhi-6",dpt, tsk));	
		assertThat(empr.findByFnameIgnoreCaseContaining("Munaaaa").isEmpty());
	}	
}
