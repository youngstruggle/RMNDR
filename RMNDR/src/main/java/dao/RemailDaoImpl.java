package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;
import entities.Remail;

/**
 * @author Nana Febriana
 */

@Repository
public class RemailDaoImpl implements RemailDao {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RcustomerDaoImpl.class);

	@Override
	public List<Remail> getEmailList() {
		List<Remail> emailList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			emailList = session.createCriteria(Remail.class).list();
			LOGGER.debug("Get userlist");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction Finish");
		}
		return emailList;
	}

	@Override
	public Remail deleteEmail(String emailId) {
		Remail remail = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			remail = (Remail) session.get(Remail.class, emailId);
			if (remail != null) {
				session.delete(remail);
				session.getTransaction().commit();
			}
			LOGGER.debug("Data sucessfully deleted!");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Delete {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction selesai");
		}
		return remail;
	}

	@Override
	public Remail createEmail(Remail remail) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if (remail != null) {
				session.beginTransaction();
				session.save(remail);
				session.getTransaction().commit();
			} else {
				System.out.println("Ada yang null!");
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error create {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction End");
		}
		return remail;
	}

	@Override
	public Remail getEmailById(String emailId) {
		Remail remail = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			remail = (Remail) session.get(Remail.class, emailId);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return remail;
	}

	@Override
	public Remail updateEmailObj(Remail remail) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			if (remail != null) {
				session.update(remail);
				session.getTransaction().commit();
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return remail;
	}

	@Override
	public List<Remail> getEmailListByQuery(String sql) {
		List<Remail> emailList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			emailList = session.createQuery(sql).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return emailList;
	}

}
