package com.employee.employee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.employee.employee.EmployeeModel.Employee;
import com.employee.employee.EmployeeRepository.EmployeeRepository;
import com.employee.employee.employeeController.employeeController;

@SpringBootTest
public class JunitTests {
	 @Autowired
	    private EmployeeRepository repository;
	 
	 @Autowired
	    private employeeController controller;
	     

	@Test
	public void testAddEmployee() {
		Employee employee = repository.save(new Employee("1","Demo", "Demo"));
		assertThat(employee.getEmpName()).isEqualTo("Demo");
	}
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	 @Test
	 @Rollback(false)
	    public void testGetEmployee()
	    {
		 Employee employee1 = repository.save(new Employee("2","Demo0", "Demo0"));
	     
	        assertThat(employee1.getEmpName()).isEqualTo("Demo0");
	    }
	 
	 @Test
	 public void testGetEmployees() {
	     List<Employee> employees = (List<Employee>) controller.getEmployees();
	     assertThat(employees).size().isGreaterThan(0);
	 }
	 
	 @Test
	 @Rollback(false)
	 public void testUpdateEmployees() {
	     Employee employee = controller.getEmployee("1");
	     employee.setEmpName("Demo2");
	      
	     repository.save(employee);
	      
	     Employee updatedEmployee = controller.getEmployee("1");
	      
	     assertThat(updatedEmployee.getEmpName()).isEqualTo("Demo2");
	 }
	 
	 @Test
	 @Rollback(false)
	 public void testDeleteEmployee() {
	     Employee employee = controller.getEmployee("2");
	      
	     controller.deleteEmployee(employee.getEmpNo());
	      
	     
	      
	     assertThat( controller.getEmployee("2")).isNull();       
	      
	 }
	
}
