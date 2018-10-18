package services;

import java.util.List;

import entities.Ruser;

/**
 * @author Nana Febriana
 */

public interface RuserServices {

	public List<Ruser> getUserList();
	public Ruser deleteUser(String userId);
	public Ruser createUser(Ruser rUser);
	public Ruser getUserById(String userId);
	public Ruser updateUserObj(Ruser rUser);
	public List<Ruser> getUserListByQuery(String sql);

}