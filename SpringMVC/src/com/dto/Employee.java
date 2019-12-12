package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "emp_name")
	private String emp_name;

	@Column(name = "emp_gender")
	private String emp_gender;

	@Column(name = "emp_mail")
	private String emp_mail;

	@Column(name = "emp_mobile")
	private String emp_mobile;

	public Employee() {
		super();
	}

	public Employee(String emp_name, String emp_gender, String emp_mail, String emp_mobile) {
		super();
		this.emp_name = emp_name;
		this.emp_gender = emp_gender;
		this.emp_mail = emp_mail;
		this.emp_mobile = emp_mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	public String getEmp_mail() {
		return emp_mail;
	}

	public void setEmp_mail(String emp_mail) {
		this.emp_mail = emp_mail;
	}

	public String getEmp_mobile() {
		return emp_mobile;
	}

	public void setEmp_mobile(String emp_mobile) {
		this.emp_mobile = emp_mobile;
	}

	@Override
	public String toString() {
		return "Employee details : emp_name=" + emp_name + ", emp_gender=" + emp_gender + ", emp_mail=" + emp_mail
				+ ", emp_mobile=" + emp_mobile+" ";
	}

}
