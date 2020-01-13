package it.roberto.hibernate.test;

import java.io.Serializable;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.roberto.hibernate.entity.User;

public class TestHibernate {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		User newUser = new User();
		newUser.setUsername("roberto");
		newUser.setPassword("roberto-password");
		newUser.setEmail("email@email.it");

		session.save(newUser);

		try {
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
