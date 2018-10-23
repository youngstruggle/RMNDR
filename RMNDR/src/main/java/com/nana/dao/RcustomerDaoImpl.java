package com.nana.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nana.entities.Rcustomer;

import util.HibernateUtil;

@Repository
public class RcustomerDaoImpl implements RcustomerDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RcustomerDaoImpl.class);

	@Override
	public List<Rcustomer> getCustomerList() {
		List<Rcustomer> customerlist = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			customerlist = session.createCriteria(Rcustomer.class).list();
			session.getTransaction().commit();
			LOGGER.debug("Get customer");
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction Finish");
		}
		return customerlist;
	}

	@Override
	public Rcustomer deleteCustomer(String customerId) {
		Rcustomer customer = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			customer = (Rcustomer) session.get(Rcustomer.class, customerId);
			if (customer != null) {
				session.delete(customer);
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
		return customer;
	}

	@Override
	public Rcustomer createCustomer(Rcustomer customer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if (customer != null) {
				session.beginTransaction();
				session.save(customer);
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
		return customer;
	}

	@Override
	public Rcustomer getCustomerById(String userId) {
		Rcustomer customer = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			customer = (Rcustomer) session.get(Rcustomer.class, userId);
			session.getTransaction().commit();
			LOGGER.debug("Get customer Byid");		

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return customer;
	}

	@Override
	public Rcustomer updateCustomerObj(Rcustomer customer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			if (customer != null) {
				session.update(customer);
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
		return customer;
	}

	@Override
	public List<Rcustomer> getCustomerListByQuery(String sql) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Rcustomer> customerlist = null;
		try {
			session.beginTransaction();
			customerlist = session.createQuery(sql).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction end");
		}
		return customerlist;
	}
}
