package dao;

import java.util.List;

import entities.Rcustomer;
import entities.Ruser;

/**
 * @author Nana Febriana
 */

public interface RcustomerDao {

	public List<Rcustomer> getCustomerList();
	public Rcustomer deleteCustomer(String customerid);
	public Rcustomer createCustomer(Rcustomer rcustomer);
	public Rcustomer getCustomerById(String customerid);
	public Rcustomer updateCustomerObj(Rcustomer rcustomer);
	public List<Rcustomer> getCustomerListByQuery(String sql);

}