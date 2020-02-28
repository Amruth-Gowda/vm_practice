package com.dao;

import java.util.List;

import com.dto.Employee;
import com.dto.Project;
import com.dto.Task;

public interface TaskDao {
	public void saveTask(Task task);
}
