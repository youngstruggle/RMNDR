package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TrReportsDao;
import entities.TrReports;

/**
 * @author Nana Febriana
 */

@Service("trReportsServices")
public class TrReportServicesImpl implements TrReportServices {

	private TrReportsDao trReportsDAO;

	@Autowired
	public void setTrReportsDAO(TrReportsDao trReportsDAO) {
		this.trReportsDAO = trReportsDAO;
	}

	@Override
	public List<TrReports> getReportList() {
		return trReportsDAO.getReportList();
	}

	@Override
	public TrReports getReportsById(int reportsId) {
		return trReportsDAO.getReportsById(reportsId);
	}

	@Override
	public TrReports updateReportsObj(TrReports reports) {
		return trReportsDAO.updateReportsObj(reports);
	}

	@Override
	public TrReports deleteReports(Integer userId) {
		return trReportsDAO.deleteReports(userId);
	}

	@Override
	public TrReports insertTrReport(TrReports reports) {
		return trReportsDAO.insertTrReport(reports);
	}

}
