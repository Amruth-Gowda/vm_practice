package com.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int taskId;

	@Column(name = "task_desc")
	private String taskDesc;

	@Column(name = "start_date")
	private Date taskStartDate;

	@Column(name = "end_date")
	private Date taskEndDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "task_employees", joinColumns = {
			@JoinColumn(name = "task_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "emp_id", referencedColumnName = "id") })
	private List<Employee> employees = new ArrayList<>();

	public Task() {
	}

	public Task(String taskDesc, Date taskStartDate, Date taskEndDate) {
		this.taskDesc = taskDesc;
		this.taskStartDate = taskStartDate;
		this.taskEndDate = taskEndDate;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Date getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskDesc=" + taskDesc + ", taskStartDate=" + taskStartDate
				+ ", taskEndDate=" + taskEndDate + "]";
	}
}
