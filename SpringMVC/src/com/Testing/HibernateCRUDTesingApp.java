package com.Testing;

import java.util.List;

import com.dao.EmployeeDAO;
import com.dto.Employee;

public class HibernateCRUDTesingApp {

	public static void main(String[] args) {

		EmployeeDAO dao = new EmployeeDAO();

//		// insert data into to the database
//		Employee employee = new Employee("xyz", "male", "abc@abc.com", "9898998425");
//		dao.addEmployee(employee);

//		//read individual data from the database
//		Employee employee2 = dao.getEmployee(1);
//		System.out.println("Employee Detailes: " + employee2);

//		// read multiple data from the database
//		List<Employee> emplList = dao.getEmployees();
//		for (Employee employee3 : emplList) {
//			System.out.println("In the Main app: " + employee3);
//		}

//		// update the employee details
//		int empId = 1;
//		Employee employee = dao.getEmployee(empId);
//		System.out.println("Current employee details are: " + employee);
//
//		employee.setEmp_name("amruth");
//		employee.setEmp_mail("amruth@amruth.com");
//		if (dao.updateEmployee(employee) == 1)
//			System.out.println("updated successfully");
//		else
//			System.out.println("update failed.");
//		
//		Employee employee2 = dao.getEmployee(empId);
//		System.out.println("Updated employee details are: " + employee2);

//		//delete an empployee
//		List<Employee> empList = dao.getEmployees();
//		System.out.println("Employee list before for deleting: ");
//		for(Employee employee: empList) {
//			System.out.println(employee);
//		}
//		
//		Employee employee = dao.getEmployee(3);
//		System.out.println("Deleting employee details: "+employee);
//		dao.deleteEmployee(employee);
//		
//		List<Employee> empList1 = dao.getEmployees();
//		System.out.println("Employee list after for deleting: ");
//		for(Employee employee1: empList1) {
//			System.out.println(employee1);
//		}

		// delete multiple employees on id basis
		List<Employee> empList = dao.getEmployees();
		System.out.println("Employee list before for deleting: ");
		for (Employee employee : empList) {
			System.out.println(employee);
		}

		dao.deleteEmployeesBasedOnPattern("%xy.com");

		List<Employee> empList1 = dao.getEmployees();
		System.out.println("Employee list after for deleting: ");
		for (Employee employee1 : empList1) {
			System.out.println(employee1);
		}
	}
}
