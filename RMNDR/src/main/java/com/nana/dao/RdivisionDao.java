package com.nana.dao;

import java.util.List;

import com.nana.entities.Rcustomer;
import com.nana.entities.Rdivision;
import com.nana.entities.Ruser;

/**
 * @author Nana Febriana
 */

public interface RdivisionDao {

	public List<Rdivision> getDivisionList();
	public Rdivision deleteDivision(String divisionid);
	public Rdivision createDivision(Rdivision rdivision);
	public Rdivision getDivisionById(String divisionid);
	public Rdivision updateDivisionObj(Rdivision rdivision);
	public List<Rdivision> getDivisionListByQuery(String sql);

}