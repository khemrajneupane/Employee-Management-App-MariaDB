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
	@Bean
	public ApplicationRunner demo(EmployeeRepository emprepo, DepartmentRepository deprepo, UserRepository usr, TaskRepository taskrepo) {
		return (args) -> {
			deprepo.save(new Department("Science"));
			deprepo.save(new Department("IT"));
			taskrepo.save(new Task("Swimming","2019","Swimming program",400,"Yes"));
			taskrepo.save(new Task("Application","1979","Building app program",3500,"No"));
			emprepo.save(new Employee("Muna","Ghimire","muna@tuna.com","43261408","Chandragadhi-6", deprepo.findByName("Science").get(0), taskrepo.findByName("Swimming").get(0)));	
			emprepo.save(new Employee("Madhan","Bhadari","madan@gadhan.com","45396108","Dhanushmod-9", deprepo.findByName("IT").get(0), taskrepo.findByName("Application").get(0)));
			
			
			/*EmployeeDB   //insert into Task values(4000,"Field marketing",true,"Marketing","2019-04-25");
			 * CREATE TABLE Department (
  departmentid INT NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (departmentid)
);
ALTER TABLE Department AUTO_INCREMENT=101;
);*/
/*CREATE TABLE Task (
			  taskid INT NOT NULL AUTO_INCREMENT,
			  name varchar(255) NOT NULL,
				startime varchar(255) DEFAULT NULL,
			  description varchar(2000) NOT NULL,
			  budget INT NOT NULL,
			  PRIMARY KEY (taskid)
			);
		//	ALTER TABLE Task AUTO_INCREMENT=301;
			*/
			/*CREATE TABLE Employee (
  id INT NOT NULL AUTO_INCREMENT,
  address varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  fname varchar(50) NOT NULL,
  lname varchar(50) NOT NULL,
  phone varchar(50) NOT NULL,
  PRIMARY KEY (id),
  departmentid INT NULL,
  taskid INT NULL,
  FOREIGN KEY (departmentid) REFERENCES Department (departmentid),
  FOREIGN KEY (taskid) REFERENCES Task (taskid)
);
	ALTER TABLE Employee AUTO_INCREMENT=301;
//
 CREATE TABLE Empfile (
  empfileid INT NOT NULL AUTO_INCREMENT,
  file longblob DEFAULT NULL,
  file_name varchar(255) DEFAULT NULL,
  mime_type varchar(255) DEFAULT NULL,
  PRIMARY KEY (empfileid)
) 
)*/ 
			
			/*		//log.info("saving hard-coded book objects");
			
			deprepo.save(new Department("IT"));
			deprepo.save(new Department("Programming"));
			deprepo.save(new Department("Romance"));
			deprepo.save(new Department("Science"));
			emprepo.save(new Employee("Mybook","Myauthor","Mydate","MyISBN","MyPrice", deprepo.findByName("Science").get(0)));
			emprepo.save(new Employee("HisBook","HisAuthor","HisDate","HisISBN","HisPrice", deprepo.findByName("Programming").get(0)));
			emprepo.save(new Employee("Zbook","Zauthor","Zdate","zISBN","Zprice", deprepo.findByName("Romance").get(0)));
			emprepo.save(new Employee("Abook","Aauthor","Adate","aISBN","Aprice", deprepo.findByName("Science").get(0)));
			
			//Create users: admin/admin user/user
						User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
						User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
						usr.save(user1);
						usr.save(user2);
		
			
	log.info("getting all employees");
			for (Employee employee : emprepo.findAll()) {
				log.info(employee.toString());
			}
	*/

		};
	}

}
