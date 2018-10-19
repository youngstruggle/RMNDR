package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;
import entities.Rdivision;

@Repository
public class RdivisionDaoImpl implements RdivisionDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RdivisionDaoImpl.class);

	@Override
	public List<Rdivision> getDivisionList() {
		List<Rdivision> divisionlist = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			divisionlist = session.createCriteria(Rdivision.class).list();
			session.getTransaction().commit();
			LOGGER.debug("Get divisionlist");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction Finish");
		}
		return divisionlist;
	}

	@Override
	public Rdivision deleteDivision(String divisionid) {
		Rdivision division = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			division = (Rdivision) session.get(Rdivision.class, divisionid);
			if (division != null) {
				session.delete(division);
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
		return division;
	}

	@Override
	public Rdivision createDivision(Rdivision rdivision) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if (rdivision != null) {
				session.beginTransaction();
				session.save(rdivision);
				session.getTransaction().commit();
				LOGGER.debug("Data sucessfully created!");
			} else {
				LOGGER.debug("Some data is null");				
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction End");
		}
		return rdivision;
	}

	@Override
	public Rdivision getDivisionById(String divisionid) {
		Rdivision division = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			division = (Rdivision) session.get(Rdivision.class, divisionid);
			session.getTransaction().commit();
			LOGGER.debug("Get division Byid");		
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return division;
	}

	@Override
	public Rdivision updateDivisionObj(Rdivision rdivision) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			if (rdivision != null) {
				session.update(rdivision);
				session.getTransaction().commit();
				LOGGER.debug("Data succesfully updated");
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return rdivision;
	}

	@Override
	public List<Rdivision> getDivisionListByQuery(String sql) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Rdivision> divisionlist = null;
		try {
			session.beginTransaction();
			divisionlist = session.createQuery(sql).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return divisionlist;
	}
}
