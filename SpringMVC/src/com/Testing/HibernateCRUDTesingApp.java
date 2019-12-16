package com.Testing;

import java.util.List;

import com.dao.EmployeeDAO;
import com.dto.Employee;

public class HibernateCRUDTesingApp {

	public static void main(String[] args) {

		EmployeeDAO dao = new EmployeeDAO();
		
		//read the list of employees
		List<Employee> emplList = dao.getEmployees();
		System.out.println("list of employees: ");
		for (Employee employee : emplList) {
			System.out.println(employee);
		}

		// insert data into to the database
		Employee employee = new Employee("navvu", "female", "nav@red.com", "9898978425");
		dao.addEmployee(employee);

//		// read individual data from the database
//		Employee employee = dao.getEmployee(13);
//		System.out.println("Employee Detailes: " + employee);

//		// update the employee details
//		int empId = 13;
//		Employee employee = dao.getEmployee(empId);
//		employee.setEmp_name("naveena");
//		employee.setEmp_mail("naveena@naveena.com");
//		if (dao.updateEmployee(employee) == 1)
//			System.out.println("updated successfully");
//		else
//			System.out.println("update failed.");
		
//		//delete an employee by id
//		Employee employee = dao.getEmployee(6);
//		System.out.println("Deleting employee details: "+employee);
//		dao.deleteEmployee(employee);
		
//		//delete multiple employees through patterns
//		dao.deleteEmployeesBasedOnPattern("%bc.com");

		// read multiple data from the database
		List<Employee> emplList1 = dao.getEmployees();
		System.out.println("Updated list of employees: ");
		for (Employee employeeUpdated : emplList1) {
			System.out.println(employeeUpdated);
		}
	}
}
