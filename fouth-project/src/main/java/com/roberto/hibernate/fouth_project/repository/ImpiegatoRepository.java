package com.roberto.hibernate.fouth_project.repository;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.roberto.hibernate.fouth_project.entity.Impiegato;
import com.roberto.hibernate.second_hibernate.util.HibernateUtil;

public class ImpiegatoRepository implements RepositoryInterface {

	private static Logger log = Logger.getLogger("ImpiegatoRepository");

	private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

	public <T> Long create(T entity) {
		log.info("class " + ImpiegatoRepository.class.getSimpleName() + "- method create(T entity) - START");
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		Long retValue = null;
		
		try {
			 trx = session.beginTransaction();
			
			 Long idEntity = ((Long) session.save(entity)).longValue();
			
		 	 trx.commit();
		 	 retValue = Long.valueOf(idEntity);
		} catch (Exception ex) {
			log.info("class " + ImpiegatoRepository.class.getSimpleName() + "- error in method create(T entity) on transcation commit");
			retValue = Long.valueOf(-1L);
			try {
				trx.rollback();				
			} catch (Exception e) {
				log.info("class " + ImpiegatoRepository.class.getSimpleName() + "- error in method create(T entity) on transcation rollback");
				log.info(e.getMessage());
				e.printStackTrace();
			}
		} finally {
			if(session != null) {
				try {
					session.close();
				} catch (Exception e) {
					log.info("class " + ImpiegatoRepository.class.getSimpleName() + "- errro in method create(T entity) on session close");
					e.printStackTrace();
				}
			}
				
		}
		
		log.info("class " + ImpiegatoRepository.class.getSimpleName() + "- method create(T entity) - END");
		return retValue;
	}

	public <T> List<T> findAll() {
		log.info("class " + ImpiegatoRepository.class.getSimpleName() + "- method findAll() - START");

		log.info("class " + ImpiegatoRepository.class.getSimpleName() + "- method findAll() - END");
		return null;
	}

	public <T> T findById(T id) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> boolean update(T entityToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> boolean delete(T id) {
		// TODO Auto-generated method stub
		return false;
	}

	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public <T> T getEntityForTest() {
		Impiegato imp = new Impiegato();
		imp.setNome("Roberto");
		imp.setSalario(1750.50);
		
		return (T) imp;	
	}

}
