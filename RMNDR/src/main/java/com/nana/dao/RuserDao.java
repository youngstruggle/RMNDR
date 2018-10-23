package com.nana.dao;

import java.util.List;

import com.nana.entities.Ruser;

/**
 * @author Nana Febriana
 */

public interface RuserDao {

	public List<Ruser> getUserList();
	public Ruser deleteUser(String userId);
	public Ruser createUser(Ruser rUser);
	public Ruser getUserById(String userId);
	public Ruser updateUserObj(Ruser rUser);
	public List<Ruser> getUserListByQuery(String sql);

}