package dao;

import java.util.List;

import entities.Remail;

public interface RemailDao {

	public List<Remail> getEmailList();
	public Remail deleteEmail(String emailId);
	public Remail createEmail(Remail remail);
	public Remail getEmailById(String emailId);
	public Remail updateEmailObj(Remail remail);
	public List<Remail> getEmailListByQuery(String sql);

}