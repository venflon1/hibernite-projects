package com.roberto.hibernate.second_hibernate.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.Table;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class HibernateUtilTest {

	 @Test
	 public void getHibernateUtilTest() {
		 HibernateUtil hibernateUtil = HibernateUtil.getInstance();
		 assertNotNull(hibernateUtil);
	 }
	 
	 @Test
	 public void getSessionFactoryTest() {
		HibernateUtil hibernateUtil = HibernateUtil.getInstance();
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		assertNotNull(sessionFactory);
	 }
	 
	 @Test
	 public void closeTest() {
		 HibernateUtil hibernateUtil = HibernateUtil.getInstance();
		 SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		 hibernateUtil.close();
		 assertEquals(false, sessionFactory.isOpen());
	 }
}
