package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dto.Employee;

public class EmployeeDAO {

	SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public void addEmployee(Employee employee) {

		Session session = factory.openSession();
		session.beginTransaction();
		session.save(employee);
		System.out.println("Saved the employee details into the database");
		session.getTransaction().commit();
		session.close();

	}

	public Employee getEmployee(int empId) {

		Session session = factory.openSession();
		session.beginTransaction();
		Employee tempEmployee = session.get(Employee.class, empId);
		session.close();
		return tempEmployee;

	}

	public List<Employee> getEmployees() {

		List<Employee> employeesList = new ArrayList<Employee>();
		Session session = factory.openSession();
		session.beginTransaction();
		employeesList = session.createQuery("from Employee").getResultList();
		session.close();
		return employeesList;

	}

	public int updateEmployee(Employee employee) {

		Session session = factory.openSession();
		session.beginTransaction();
		int value = session.createQuery("update Employee set emp_name= '" + employee.getEmp_name() + "', emp_mail='"
				+ employee.getEmp_mail() + "'  where id = " + employee.getId()).executeUpdate();
		session.getTransaction().commit();
		session.close();
		return value;

	}

	public void deleteEmployee(Employee employee) {

		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(employee);
		session.getTransaction().commit();
		session.close();

	}

	public void deleteEmployeesBasedOnPattern(String condition) {

		Session session = factory.openSession();
		session.beginTransaction();
		session.createQuery("delete from Employee where emp_mail like '"+condition+"'").executeUpdate();
		session.getTransaction().commit();
		session.close();

	}

}
