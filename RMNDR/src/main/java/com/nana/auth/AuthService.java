package com.nana.auth;

import java.util.List;

import org.apache.log4j.Logger;

import com.nana.dao.RuserDao;
import com.nana.dao.RuserDaoImpl;
import com.nana.entities.Ruser;

/**
 * @author Nana Febriana
 */

public class AuthService {
	private static Logger log = Logger.getLogger(AuthService.class);

	public AuthService() {
	}

	public boolean findUser(String uname, String upwd) {
		boolean isValidUser = false;
		String sqlQuery = "from Ruser WHERE username = " + "'"+ uname + "'" + " AND PASSWORD = " + "'"+ upwd + "'";
		System.out.println("sqlQuery ====> " + sqlQuery);
		try {			
			RuserDao rDao = new RuserDaoImpl();
			List<Ruser> userList = rDao.getUserListByQuery(sqlQuery);									
			if (userList != null && userList.size() > 0) {
				System.out.println("usersize " + userList.size());
				isValidUser = true;
			}
		} catch (Exception e) {
			isValidUser = false;
			log.error("An error occurred while fetching the user details from the database",e);
		}
		return isValidUser;
	}
	
	public boolean checkUsernameAndEmail(String uname, String email) {
		boolean isValidUser = false;
		String sqlQuery = "from Ruser WHERE username = " + "'"+ uname + "'" + " OR emailAddress = " + "'"+ email + "'";
		System.out.println("sqlQuery ====> " + sqlQuery);
		try {			
			RuserDao rDao = new RuserDaoImpl();
			List<Ruser> userList = rDao.getUserListByQuery(sqlQuery);									
			if (userList != null && userList.size() > 0) {
				System.out.println("usersize " + userList.size());
				isValidUser = true;
			}
		} catch (Exception e) {
			isValidUser = false;
			log.error("An error occurred while fetching the user details from the database",e);
		}
		return isValidUser;
	}
}
