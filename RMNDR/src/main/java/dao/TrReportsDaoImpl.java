package dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.stereotype.Repository;

import entities.TrReports;
import util.HibernateUtil;

/**
 * @author Nana Febriana
 */

@Repository
public class TrReportsDaoImpl implements TrReportsDao {

	@Override
	public List<TrReports> getReportList() {
		List<TrReports> trReports = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			trReports = session.createCriteria(TrReports.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trReports;
	}

	@Override
	public TrReports getReportsById(int reportsId) {
		TrReports reports = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			reports = (TrReports) session.get(TrReports.class, reportsId);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reports;
	}

	@Override
	public TrReports updateReportsObj(TrReports reports) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			if (reports != null) {
				session.update(reports);
				session.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return reports;
	}

	@Override
	public TrReports deleteReports(Integer userId) {
		TrReports reports = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			reports = (TrReports) session.get(TrReports.class, userId);
			if (reports != null) {
				session.delete(reports);
				session.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reports;
	}

	@Override
	public TrReports insertTrReport(TrReports reports) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(reports);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return reports;
	}

}
