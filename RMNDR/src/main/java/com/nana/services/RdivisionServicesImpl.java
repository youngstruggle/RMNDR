package com.nana.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nana.dao.RdivisionDao;
import com.nana.entities.Rdivision;

/**
 * @author Nana Febriana
 */

@Service("divisionServices")
public class RdivisionServicesImpl implements RdivisionServices {

	private RdivisionDao rdivision;

	@Autowired
	public void setRdivision(RdivisionDao rdivision) {
		this.rdivision = rdivision;
	}

	@Override
	public List<Rdivision> getDivisionList() {
		return rdivision.getDivisionList();
	}

	@Override
	public Rdivision deleteDivision(String divisionid) {
		return rdivision.deleteDivision(divisionid);
	}

	@Override
	public Rdivision createDivision(Rdivision division) {
		return rdivision.createDivision(division);
	}

	@Override
	public Rdivision getDivisionById(String divisionid) {
		return rdivision.getDivisionById(divisionid);
	}

	@Override
	public Rdivision updateDivisionObj(Rdivision division) {
		return rdivision.updateDivisionObj(division);
	}

	@Override
	public List<Rdivision> getDivisionListByQuery(String sql) {
		return rdivision.getDivisionListByQuery(sql);
	}

}
