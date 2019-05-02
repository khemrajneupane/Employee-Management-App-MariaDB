package fi.employee.employeerecord.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import fi.employee.employeerecord.domain.Department;
import fi.employee.employeerecord.domain.DepartmentRepository;
import fi.employee.employeerecord.domain.Employee;
import fi.employee.employeerecord.domain.EmployeeRepository;
import fi.employee.employeerecord.domain.Task;
import fi.employee.employeerecord.domain.TaskRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeerepository;
	@Autowired
	private DepartmentRepository departmentrepository;
	@Autowired
	private TaskRepository taskrepository;

	// Show all books
	@RequestMapping(value = { "/index", "/", "/login", "/*", "*/", "*" })
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/logout" })
	public String logout() {
		return "logout";
	}

	// Add new employee
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/add")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("department", departmentrepository.findAll());
		model.addAttribute("task", taskrepository.findAll());
		return "addemployee";
	}

	@RequestMapping(value = "/addep")
	public String addDepartment(Model model) {
		model.addAttribute("department", new Department());
		return "addep";
	}

	// adding tasks
	@RequestMapping(value = "/addtask")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		return "addtask";
	}

	@RequestMapping(value = "/employeelist")
	public String employeeStore(Model model) {
		model.addAttribute("employees", employeerepository.findAll());
		return "employeelist";
	}

	// For Creating History of employees
	@RequestMapping(value = "/history")
	public String history(Model model) {
		model.addAttribute("employees", employeerepository.findAll());
		return "history";
	}

	// For Restful Api creation:
	// GET all
	/* http://localhost:8080/employee/all */
	@RequestMapping(value = "/employee/all", method = RequestMethod.GET)
	public @ResponseBody List<Employee> employeeList() {
		return (List<Employee>) employeerepository.findAll();
	}

	// GET all Tasks only
	/* http://localhost:8080/employee/tasks */
	@RequestMapping(value = "employee/task", method = RequestMethod.GET)
	public @ResponseBody List<Task> tasks() {
		return (List<Task>) taskrepository.findAll();
	}

	// GET all Department/employee only
	/* http://localhost:8080/department/employee */
	@RequestMapping(value = "department/employee", method = RequestMethod.GET)
	public @ResponseBody List<Department> department() {
		return (List<Department>) departmentrepository.findAll();
	}

	// GET BY ID
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Employee> findEmployeeRest(@PathVariable("id") Long employeeId) {
		return employeerepository.findById(employeeId);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Employee employee, Department department, Task task) {
		employeerepository.save(employee);
		departmentrepository.save(department);
		taskrepository.save(task);
		return "redirect:/employeelist";
	}

	@RequestMapping(value = "/savedep", method = RequestMethod.POST)
	public String save(Department department) {
		departmentrepository.save(department);
		return "redirect:/add";
	}

	@RequestMapping(value = "/savetask", method = RequestMethod.POST)
	public String save(Task task) {
		taskrepository.save(task);
		return "redirect:/add";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") Long employeeId, Model model) {
		employeerepository.deleteById(employeeId);
		return "redirect:../employeelist";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editEmployee(@PathVariable("id") Long employeeId, Model model) {
		model.addAttribute("employee", employeerepository.findById(employeeId));
		model.addAttribute("department", departmentrepository.findAll());
		model.addAttribute("task", taskrepository.findAll());
		return "editemployee";
	}

	@RequestMapping(value = "/update/{id}")
	public String updateEmployee(@PathVariable("id") Long employeeId, Model model) {
		model.addAttribute("employee", employeerepository.findById(employeeId));
		model.addAttribute("department", departmentrepository.findAll());
		model.addAttribute("task", taskrepository.findAll());
		return "history";
	}

	// Search by task name
	@GetMapping(value = "/search")
	public String searchName(@RequestParam(name = "fname") String fname, Model model) {
		model.addAttribute("employees", employeerepository.findByFnameIgnoreCaseContaining(fname));
		return "employeelist";
	}

	// Make employee history
	@GetMapping(value = "/histori")
	public String searchHistory(@RequestParam(name = "fname") String fname, Model model) {
		model.addAttribute("employees", employeerepository.findByFname(fname));
		return "history";
	}

}