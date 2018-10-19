package services;

import java.util.List;

import entities.Rcustomer;
import entities.Rdivision;
import entities.Ruser;

/**
 * @author Nana Febriana
 */

public interface RdivisionServices {

	public List<Rdivision> getDivisionList();
	public Rdivision deleteDivision(String divisionid);
	public Rdivision createDivision(Rdivision rdivision);
	public Rdivision getDivisionById(String divisionid);
	public Rdivision updateDivisionObj(Rdivision rdivision);
	public List<Rdivision> getDivisionListByQuery(String sql);

}