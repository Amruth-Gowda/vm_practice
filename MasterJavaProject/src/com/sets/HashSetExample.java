package com.sets;

import java.util.HashSet;

import com.model.Employee;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet<Employee> employees = new HashSet<Employee>();
		
		Employee employee2 = new Employee("abc", "989898", 15000);
		Employee employee3 = new Employee("efg", "787878", 10000);
		Employee employee4 = new Employee("abc", "989898", 15000);
		Employee employee5 = new Employee("hij", "656565", 25000);
		Employee employee6 = new Employee("efg", "787878", 10000);
		Employee employee7 = new Employee("lmo", "929292", 5000);
		
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
		employees.add(employee6);
		employees.add(employee7);
		
		for(Employee emp: employees) {
			System.out.println(emp);
//			System.out.println(emp.hashCode());
		}
	}

}
