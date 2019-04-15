package fi.employee.employeerecord.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String address;
	
//Employee to Department has ManyToOne relation
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "departmentid")
	private Department department;
    
 //Employee to Task has ManyToOne relation
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "taskid")
	private Task task;
    
	public Employee() {
		super();
	}

	public Employee(String fname, String lname, String email, String phone, String address, Department department, Task task) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.department = department;
		this.task = task;
	
	}

	public Long getId() {
		return id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", department=" + department + ", task=" + task + "]";
	}



}
