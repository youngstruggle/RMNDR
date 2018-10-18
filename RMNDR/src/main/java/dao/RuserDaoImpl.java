package dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;
import entities.Ruser;

/**
 * @author Nana Febriana
 */

@Repository
public class RuserDaoImpl implements RuserDao {

	@Override
	public List<Ruser> getUserList() {
		List<Ruser> userList = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			userList = session.createCriteria(Ruser.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public Ruser deleteUser(String userId) {
		Ruser rUser = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			 rUser = (Ruser) session.get(Ruser.class, userId);
			if (rUser != null) {
				session.delete(rUser);
				session.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rUser;
	}

	@Override
	public Ruser createUser(Ruser rUser) {
		try {
			if (rUser != null) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
//				UUID uuid = UUID.randomUUID();
//				rUser.setUserId(uuid.toString());
//				
//				System.out.println("id " + uuid);
				System.out.println(rUser.getUserId());
				System.out.println(rUser.getUsername());
				session.save(rUser);
				session.getTransaction().commit();
			} else {
				System.out.println("Ada yang null!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rUser;
	}

	@Override
	public Ruser getUserById(String userId) {
		Ruser user = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			user = (Ruser) session.get(Ruser.class, userId);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Ruser updateUserObj(Ruser rUser) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			if (rUser != null) {
				session.update(rUser);
				session.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rUser;
	}

	@Override
	public List<Ruser> getUserListByQuery(String sql) {
		List<Ruser> userList = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			userList = session.createQuery(sql).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

}
