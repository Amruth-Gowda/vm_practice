package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static void createSessionFactory() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	}
}
