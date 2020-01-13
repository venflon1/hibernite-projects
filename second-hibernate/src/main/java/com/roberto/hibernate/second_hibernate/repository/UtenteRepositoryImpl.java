package com.roberto.hibernate.second_hibernate.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.roberto.hibernate.second_hibernate.entity.Utente;
import com.roberto.hibernate.second_hibernate.repository.UtenteRepository;
import com.roberto.hibernate.second_hibernate.util.HibernateUtil;
import com.sun.xml.bind.v2.model.core.ID;

public class UtenteRepositoryImpl implements UtenteRepository {

	private HibernateUtil hibernateUtil = HibernateUtil.getInstance();
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

	public List<Utente> findAll() {
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		List<Utente> list = null;

		try {
			trx = session.beginTransaction();
			
			Query query = session.createQuery("SELECT usr FROM Utente usr");
			list = query.getResultList();
			
			trx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			trx.rollback();
		} finally {
			if(session != null)
				session.close();
		}

		return list;
	}

	public Utente findById(Long id) {
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		Utente usr = null;
		
		try {
			trx = session.beginTransaction();

			usr = session.find(Utente.class, id);
			
			trx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			trx.rollback();

		} finally {
			if(session != null)
				session.close();
		}
		

		return usr;
	}

	public Long save(Utente message) {
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		Long ID_SERIALIZATION_Message =  null;
		
		try {
			trx = session.beginTransaction();

			ID_SERIALIZATION_Message = new Long(( (Long) session.save(message)).longValue());
			
			trx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			trx.rollback();
		} finally {
			if(session != null)
				session.close();
		}		
		
		return ID_SERIALIZATION_Message;
	}

	public Utente update(Long id, Utente message) {
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		Utente usrUpdated = null;
		
		try {
			trx = session.beginTransaction();

			Utente usrFounded = this.findById(id);
			if(usrFounded == null)
				return null;
			
			usrFounded.setId(message.getId());
			usrFounded.setEmail(message.getEmail());
			usrFounded.setPassword(message.getPassword());
			usrFounded.setUsername(message.getUsername());
			usrFounded.setTimestamp(message.getTimestamp());
			
			session.update(usrFounded);
			
			trx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			trx.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		
		return this.findById(id);
	}


	public void delete(Long id) {
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		Utente usrToDelete = null;
		
		try {
			trx = session.beginTransaction();

			usrToDelete = this.findById(id);
			if(usrToDelete == null)
				return;
			
			session.delete(usrToDelete);
			
			trx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			trx.rollback();
		} finally {
			if(session != null)
				session.close();
		}
	}
}
