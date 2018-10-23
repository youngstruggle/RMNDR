package com.nana.services;

import java.util.List;

import com.nana.entities.Remail;

public interface RemailServices {

	public abstract List<Remail> getEmailList();
	public abstract Remail deleteEmail(String emailId);
	public abstract Remail createEmail(Remail email);
	public abstract Remail getEmailById(String emailId);
	public abstract Remail updateEmailObj(Remail email);
	public abstract List<Remail> getEmailListByQuery(String sql);

}