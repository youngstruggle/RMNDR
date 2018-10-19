package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;
import entities.Ruser;

/**
 * @author Nana Febriana
 */

@Repository
public class RuserDaoImpl implements RuserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RcustomerDaoImpl.class);
	
	@Override
	public List<Ruser> getUserList() {
		List<Ruser> userList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			userList = session.createCriteria(Ruser.class).list();
			LOGGER.debug("Get userlist");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction Finish");
		}
		return userList;
	}

	@Override
	public Ruser deleteUser(String userId) {
		Ruser rUser = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			 rUser = (Ruser) session.get(Ruser.class, userId);
			if (rUser != null) {
				session.delete(rUser);
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
		return rUser;
	}

	@Override
	public Ruser createUser(Ruser ruser) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if (ruser != null) {
				session.beginTransaction();
				session.save(ruser);
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
		return ruser;
	}

	@Override
	public Ruser getUserById(String userId) {
		Ruser user = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			user = (Ruser) session.get(Ruser.class, userId);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return user;
	}

	@Override
	public Ruser updateUserObj(Ruser ruser) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			if (ruser != null) {
				session.update(ruser);
				session.getTransaction().commit();
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return ruser;
	}

	@Override
	public List<Ruser> getUserListByQuery(String sql) {
		List<Ruser> userList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			userList = session.createQuery(sql).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return userList;
	}

}
