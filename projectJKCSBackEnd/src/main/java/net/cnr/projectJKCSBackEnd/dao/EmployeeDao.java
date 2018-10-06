package net.cnr.projectJKCSBackEnd.dao;

import java.util.List;

import net.cnr.projectJKCSBackEnd.dto.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployee();
	public List<Employee> getActiveEmployee();
	public Employee getEmployeeById(Integer id);

	
	public boolean createEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(Employee employee);
}
