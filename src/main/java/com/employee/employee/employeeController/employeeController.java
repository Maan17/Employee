package com.employee.employee.employeeController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.EmployeeModel.Employee;
import com.employee.employee.EmployeeRepository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class employeeController {

	@Autowired
	private EmployeeRepository employeeDAO;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmployees() {
		List<Employee> list = employeeDAO.findAll();
		return list;
	}

	@RequestMapping(value = "/employee/{empNo}", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployee(@PathVariable("empNo") String empNo) {

		return employeeDAO.getById(empNo);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee emp) {

		return employeeDAO.save(emp);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	@ResponseBody
	public Employee updateEmployee(@RequestBody Employee emp) {

		return employeeDAO.save(emp);
	}

	@RequestMapping(value = "/employee/{empNo}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteEmployee(@PathVariable("empNo") String empNo) {

		employeeDAO.deleteById(empNo);
	}

}