package fi.employee.employeerecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.employee.employeerecord.domain.Department;
import fi.employee.employeerecord.domain.DepartmentRepository;
import fi.employee.employeerecord.domain.Employee;
import fi.employee.employeerecord.domain.EmployeeRepository;
import fi.employee.employeerecord.domain.Task;
import fi.employee.employeerecord.domain.TaskRepository;
import fi.employee.employeerecord.domain.UserRepository;

@SpringBootApplication

public class EmployeeRecordApplication {
	private static final Logger log = LoggerFactory.getLogger(EmployeeRecordApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRecordApplication.class, args);
	}
	private	EmployeeRepository emprepo;
	private DepartmentRepository deprepo;
	private TaskRepository taskrepo;

//Constructor that helps to delete Entities if they are already existing.
	public EmployeeRecordApplication(EmployeeRepository emprepo, DepartmentRepository deprepo, UserRepository usr, TaskRepository taskrepo) {
		this.emprepo = emprepo;
		this.deprepo = deprepo;
		this.taskrepo = taskrepo;
	}
	@Bean
	public ApplicationRunner demo(EmployeeRepository emprepo, DepartmentRepository deprepo, UserRepository usr, TaskRepository taskrepo) {
		return (args) -> {
			this.emprepo.deleteAll();
			this.deprepo.deleteAll();
			this.taskrepo.deleteAll();
		//Following data are inserted at the first execution.
			deprepo.save(new Department("SCIENCE"));
			deprepo.save(new Department("IT"));
			
			taskrepo.save(new Task("SWIMMING","2019","Swimming program",400,"Yes"));
			taskrepo.save(new Task("APPLICATION","1979","Building app program",3500,"No"));
			
			emprepo.save(new Employee("Muna","Ghimire","muna@tuna.com","43261408","Chandragadhi-6", deprepo.findByName("Science").get(0), taskrepo.findByName("Swimming").get(0)));	
			emprepo.save(new Employee("Madhan","Bhadari","madan@gadhan.com","45396108","Dhanushmod-9", deprepo.findByName("IT").get(0), taskrepo.findByName("Application").get(0)));
			
		};
	}

}
