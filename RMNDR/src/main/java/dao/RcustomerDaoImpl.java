package dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;
import entities.Rcustomer;

@Repository
public class RcustomerDaoImpl implements RcustomerDao {

	@Override
	public List<Rcustomer> getCustomerList() {
		List<Rcustomer> customerlist = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			customerlist = session.createCriteria(Rcustomer.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerlist;
	}

	@Override
	public Rcustomer deleteCustomer(String customerId) {
		Rcustomer customer = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			customer = (Rcustomer) session.get(Rcustomer.class, customerId);
			if (customer != null) {
				session.delete(customer);
				session.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Rcustomer createCustomer(Rcustomer customer) {
		try {
			if (customer != null) {
				Session session = HibernateUtil.getSessionFactory()
						.openSession();
				session.beginTransaction();
				session.save(customer);
				session.getTransaction().commit();
			} else {
				System.out.println("Ada yang null!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public Rcustomer getCustomerById(String userId) {
		Rcustomer customer = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			customer = (Rcustomer) session.get(Rcustomer.class, userId);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Rcustomer updateCustomerObj(Rcustomer customer) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			if (customer != null) {
				session.update(customer);
				session.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Rcustomer> getCustomerListByQuery(String sql) {
		List<Rcustomer> customerlist = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			customerlist = session.createQuery(sql).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerlist;
	}
}
