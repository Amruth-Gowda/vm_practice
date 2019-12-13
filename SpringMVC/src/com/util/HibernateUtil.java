package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static HibernateUtil hibernateUtil;
	private static SessionFactory sessionFactory;

	private HibernateUtil() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static HibernateUtil getInstance() {
		if (hibernateUtil == null)
			hibernateUtil = new HibernateUtil();
		return hibernateUtil;
	}

	public Session getSession() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}

	public void commitSession(Session session) {
		session.getTransaction().commit();
	}
	
	public void commitCloseSession(Session session) {
		session.getTransaction().commit();
		session.close();
	}
	
	public void closeSession(Session session) {
		session.close();
	}
}
