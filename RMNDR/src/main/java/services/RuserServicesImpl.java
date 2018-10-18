package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RuserDao;
import entities.Ruser;

/**
 * @author Nana Febriana
 */

@Service("rUserServices")
public class RuserServicesImpl implements RuserServices {

	private RuserDao ruser;

	@Autowired
	public void setrUser(RuserDao rUser) {
		this.ruser = rUser;
	}

	@Override
	public List<Ruser> getUserList() {
		return ruser.getUserList();
	}

	@Override
	public Ruser deleteUser(String userId) {
		return ruser.deleteUser(userId);
	}

	@Override
	public Ruser createUser(Ruser rUser) {
		return ruser.createUser(rUser);
	}

	@Override
	public Ruser getUserById(String userId) {
		return ruser.getUserById(userId);
	}

	@Override
	public Ruser updateUserObj(Ruser rUser) {
		return ruser.updateUserObj(rUser);
	}

	@Override
	public List<Ruser> getUserListByQuery(String sql) {
		return ruser.getUserListByQuery(sql);
	}
}
