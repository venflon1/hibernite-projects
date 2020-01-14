package com.roberto.hibernate.second_hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static HibernateUtil _instance = null;
	
	private SessionFactory sessionFcatory = null;
	
	private HibernateUtil() {
		super();
		
		this.sessionFcatory = new Configuration()
								.configure("hibernate.cfg.xml")	
									.buildSessionFactory();
	}
	
	public static synchronized HibernateUtil getInstance() {
		if(HibernateUtil._instance == null)
			HibernateUtil._instance = new HibernateUtil();
		return HibernateUtil._instance;
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFcatory;
	}
	
	public void close() {
		this.sessionFcatory.close();
	}
	
}
