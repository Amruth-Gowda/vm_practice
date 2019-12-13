package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.dto.Employee;
import com.util.HibernateUtil;

public class EmployeeDAO {

	HibernateUtil hibernateUtil = HibernateUtil.getInstance();

	public void addEmployee(Employee employee) {
		Session session = hibernateUtil.getSession();
		session.save(employee);
		hibernateUtil.commitCloseSession(session);
	}

	public Employee getEmployee(int empId) {
		Session session = hibernateUtil.getSession();
		Employee tempEmployee = session.get(Employee.class, empId);
		hibernateUtil.closeSession(session);
		return tempEmployee;
	}

	public List<Employee> getEmployees() {
		List<Employee> employeesList = new ArrayList<Employee>();
		Session session = hibernateUtil.getSession();
		employeesList = session.createQuery("from Employee").getResultList();
		hibernateUtil.closeSession(session);
		return employeesList;
	}

	public int updateEmployee(Employee employee) {
		Session session = hibernateUtil.getSession();
		int value = session.createQuery("update Employee set emp_name= '" + employee.getEmp_name() + "', emp_mail='"
				+ employee.getEmp_mail() + "'  where id = " + employee.getId()).executeUpdate();
		hibernateUtil.commitCloseSession(session);
		return value;
	}

	public void deleteEmployee(Employee employee) {
		Session session = hibernateUtil.getSession();
		session.delete(employee);
		hibernateUtil.commitCloseSession(session);

	}

	public void deleteEmployeesBasedOnPattern(String condition) {
		Session session = hibernateUtil.getSession();
		session.createQuery("delete from Employee where emp_mail like '" + condition + "'").executeUpdate();
		hibernateUtil.commitCloseSession(session);
	}

}
