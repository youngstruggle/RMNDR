package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RcustomerDao;
import dao.RuserDao;
import entities.Rcustomer;
import entities.Ruser;

/**
 * @author Nana Febriana
 */

@Service("customerServices")
public class RcustomerServicesImpl implements RcustomerServices {

	private RcustomerDao rcustomer;

	@Autowired
	public void setRcustomer(RcustomerDao rcustomer) {
		this.rcustomer = rcustomer;
	}

	@Override
	public List<Rcustomer> getCustomerList() {
		return rcustomer.getCustomerList();
	}

	@Override
	public Rcustomer deleteCustomer(String customerid) {
		return rcustomer.deleteCustomer(customerid);
	}

	@Override
	public Rcustomer createCustomer(Rcustomer customer) {
		return rcustomer.createCustomer(customer);
	}

	@Override
	public Rcustomer getCustomerById(String customerid) {
		return rcustomer.getCustomerById(customerid);
	}

	@Override
	public Rcustomer updateCustomerObj(Rcustomer customer) {
		return rcustomer.updateCustomerObj(customer);
	}

	@Override
	public List<Rcustomer> getCustomerListByQuery(String sql) {
		return rcustomer.getCustomerListByQuery(sql);
	}

}
