package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveProject(Project project) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("saving project object...");
		session.save(project);
	}

}
