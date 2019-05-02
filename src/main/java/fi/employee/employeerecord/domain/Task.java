package fi.employee.employeerecord.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long taskid;
	private String name, startime, description;
	private Integer budget;
	private String isActive;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
	private List<Employee> employees;

	public Task() {
		super();
	}

	public Task(String name, String startime, String description, Integer budget, String isActive) {
		super();
		this.name = name;
		this.startime = startime;
		this.description = description;
		this.budget = budget;
		this.isActive = isActive;
	}

	public Long getTaskid() {
		return taskid;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toUpperCase();//All task names must be in upper case letters.
	}

	public String getStartime() {
		return startime;
	}

	public void setStartime(String startime) {
		this.startime = startime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", name=" + name + ", startime=" + startime + ", description=" + description
				+ ", budget=" + budget + ", isActive=" + isActive + "]";
	}

}
