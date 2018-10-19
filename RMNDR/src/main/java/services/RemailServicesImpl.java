package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RemailDao;
import entities.Remail;

/**
 * @author Nana Febriana
 */

@Service("rEmailServices")
public class RemailServicesImpl implements RemailServices {

	private RemailDao remail;

	@Autowired
	public void setRemail(RemailDao remail) {
		this.remail = remail;
	}

	@Override
	public List<Remail> getEmailList() {
		return remail.getEmailList();
	}

	@Override
	public Remail deleteEmail(String emailId) {
		return remail.deleteEmail(emailId);
	}

	@Override
	public Remail createEmail(Remail email) {
		return remail.createEmail(email);
	}

	@Override
	public Remail getEmailById(String emailId) {
		return remail.getEmailById(emailId);
	}

	@Override
	public Remail updateEmailObj(Remail email) {
		return remail.updateEmailObj(email);
	}

	@Override
	public List<Remail> getEmailListByQuery(String sql) {
		return remail.getEmailListByQuery(sql);
	}

}
